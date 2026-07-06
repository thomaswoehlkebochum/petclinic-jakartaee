package org.woehlke.jakartaee.petclinic.it.ui;

import lombok.extern.java.Log;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.woehlke.jakartaee.petclinic.deployments.Deployments;
import org.woehlke.jakartaee.petclinic.deployments.UnitTestData;
import org.woehlke.jakartaee.petclinic.it.ui.pages.HomePage;
import org.woehlke.jakartaee.petclinic.it.ui.pages.SpecialtyPage;
import org.woehlke.jakartaee.petclinic.it.ui.pages.VeterinarianPage;

import java.net.URL;

import static org.jboss.arquillian.graphene.Graphene.goTo;
import static org.jboss.arquillian.graphene.Graphene.waitForHttp;

@Log
@RunAsClient
@RunWith(Arquillian.class)
public class VetUiTest extends UnitTestData {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return Deployments.createDeployment();
    }

    @Drone
    WebDriver driver;

    @ArquillianResource
    URL deploymentUrl;

    @Page
    private HomePage homePage;

    @Page
    private VeterinarianPage veterinarianPage;

    @Page
    SpecialtyPage specialtyPage;

    private void goToVeterinarianPage(){
        goTo(VeterinarianPage.class);
        waitForHttp(VeterinarianPage.class);
        veterinarianPage.fullscreen();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
    }

    private void goToSpecialtyPage(){
        goTo(SpecialtyPage.class);
        specialtyPage.fullscreen();
        Assert.assertTrue(specialtyPage.isFlowStateList());
    }

    @Test
    @InSequence(1)
    public void openHomePage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openHomePage ");
        log.info("------------------------------------------------------------------------------------");
        goTo(HomePage.class);
        homePage.assertPageIsLoaded();
        log.info("------------------------------------------------------------------------------------");
        log.info(" openHomePage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(2)
    public void addNewSpecialtyPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewSpecialtyPageWithSave ");
        log.info("------------------------------------------------------------------------------------");
        goToSpecialtyPage();
        Assert.assertTrue(specialtyPage.isFlowStateList());
        for(String name:specialtyNameArray){
            specialtyPage.clickAddNewEntityButton();
            Assert.assertTrue(specialtyPage.isFlowStateNew());
            specialtyPage.addNewEntity(name);
            Assert.assertTrue(specialtyPage.isFlowStateDetails());
            specialtyPage.clickCancelDetailsButton();
            Assert.assertTrue(specialtyPage.isFlowStateList());
        }
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewSpecialtyPageWithSave DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(3)
    public void openVeterinarianPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openVeterinarianPage ");
        log.info("------------------------------------------------------------------------------------");
        goToVeterinarianPage();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openVeterinarianPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(4)
    public void addNewVeterinarianPageWithCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewVeterinarianPage ");
        log.info("------------------------------------------------------------------------------------");
        goToVeterinarianPage();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        veterinarianPage.clickAddNewEntityButton();
        Assert.assertTrue(veterinarianPage.isFlowStateNew());
        veterinarianPage.clickCancelNewEntityButton();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewVeterinarianPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(5)
    public void addNewVeterinarianPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewSpecialtyPageWithSave ");
        log.info("------------------------------------------------------------------------------------");
        goToVeterinarianPage();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        for(String name[]: vetNames1Array){
            veterinarianPage.clickAddNewEntityButton();
            Assert.assertTrue(veterinarianPage.isFlowStateNew());
            veterinarianPage.addNewEntity(name[0],name[1]);
            Assert.assertTrue(veterinarianPage.isFlowStateDetails());
            veterinarianPage.clickCancelDetailsButton();
            Assert.assertTrue(veterinarianPage.isFlowStateList());
        }
        log.info("------------------------------------------------------------------------------------");
        log.info(" addNewSpecialtyPageWithSave DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(6)
    public void openVeterinarianDetailsPage() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" openVeterinarianDetailsPage ");
        log.info("------------------------------------------------------------------------------------");
        goToVeterinarianPage();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        veterinarianPage.clickShowDetailsFormButton0();
        Assert.assertTrue(veterinarianPage.isFlowStateDetails());
        veterinarianPage.clickCancelDetailsButton();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" openVeterinarianDetailsPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(7)
    public void editVeterinarianPageWithCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editVeterinarianPage ");
        log.info("------------------------------------------------------------------------------------");
        goToVeterinarianPage();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        veterinarianPage.clickShowDetailsFormButton0();
        Assert.assertTrue(veterinarianPage.isFlowStateDetails());
        veterinarianPage.clickShowEditForm();
        Assert.assertTrue(veterinarianPage.isFlowStateEdit());
        veterinarianPage.clickCancelEditButton();
        Assert.assertTrue(veterinarianPage.isFlowStateDetails());
        veterinarianPage.clickCancelDetailsButton();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" editVeterinarianPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(8)
    public void editVeterinarianPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" editSpecialtyPage ");
        log.info("------------------------------------------------------------------------------------");
        goToVeterinarianPage();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        for(int i=0; i<3; i++){
            log.info(" "+i);
            veterinarianPage.clickShowDetailsFormButton(i);
            Assert.assertTrue(veterinarianPage.isFlowStateDetails());
            veterinarianPage.clickShowEditForm();
            Assert.assertTrue(veterinarianPage.isFlowStateEdit());
            veterinarianPage.editNameAddString();
            Assert.assertTrue(veterinarianPage.isFlowStateDetails());
            veterinarianPage.clickCancelDetailsButton();
            Assert.assertTrue(veterinarianPage.isFlowStateList());
        }
        log.info("------------------------------------------------------------------------------------");
        log.info(" editSpecialtyPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(9)
    public void deleteVeterinarianPageWithCancel() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteVeterinarianPage ");
        log.info("------------------------------------------------------------------------------------");
        goToVeterinarianPage();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        veterinarianPage.clickShowDetailsFormButton1();
        Assert.assertTrue(veterinarianPage.isFlowStateDetails());
        veterinarianPage.clickShowDeleteForm();
        Assert.assertTrue(veterinarianPage.isFlowStateDelete());
        veterinarianPage.clickCancelDeleteButton();
        Assert.assertTrue(veterinarianPage.isFlowStateDetails());
        veterinarianPage.clickCancelDetailsButton();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteVeterinarianPage DONE ");
        log.info("------------------------------------------------------------------------------------");
    }

    @Test
    @InSequence(10)
    public void deleteVeterinarianPageWithSave() {
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteSpecialtyPageWithSave ");
        log.info("------------------------------------------------------------------------------------");
        goToVeterinarianPage();
        Assert.assertTrue(veterinarianPage.isFlowStateList());
        for(int i=0; i<3; i++) {
            veterinarianPage.clickShowDetailsFormButton0();
            Assert.assertTrue(veterinarianPage.isFlowStateDetails());
            veterinarianPage.clickShowDeleteForm();
            Assert.assertTrue(veterinarianPage.isFlowStateDelete());
            veterinarianPage.clickSaveDeleteButton();
            Assert.assertTrue(veterinarianPage.isFlowStateList());
        }
        log.info("------------------------------------------------------------------------------------");
        log.info(" deleteSpecialtyPageWithSave DONE ");
        log.info("------------------------------------------------------------------------------------");
    }
}
