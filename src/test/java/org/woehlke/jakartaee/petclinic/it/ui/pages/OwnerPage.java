/*
All the code that follow is
Copyright (c) 2022, Thomas Woehlke. All Rights Reserved.
Not for reuse without permission.
*/

package org.woehlke.jakartaee.petclinic.it.ui.pages;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.NoSuchElementException;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.primefaces.selenium.component.DatePicker;
import org.primefaces.selenium.component.InputText;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.owner.views.OwnerFlowState;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import static java.text.DateFormat.SHORT;


@Location("owner.jsf")
public class OwnerPage implements CrudFlowStatePageOwner {

    @Drone
    private WebDriver driver;

    @FindBy(id="ownerViewFlowFlowState")
    private GrapheneElement ownerFlowState;

    @FindBy(id = "entityDataTableForm:showNewFormButton")
    private GrapheneElement showNewFormButton;

    @FindBy(id = "addNewOwnerForm:cancelAddNewOwner")
    private GrapheneElement cancelNewButton;

    @FindBy(id = "detailsOwnerForm:showEditFormButtonInList")
    private GrapheneElement showEditFormButton;

    @FindBy(id = "editOwnerForm:cancelEditOwner")
    private GrapheneElement cancelEditButton;

    @FindBy(id = "detailsOwnerForm:deleteSelectedButton")
    private GrapheneElement deleteSelectedButton;

    @FindBy(id = "deleteOwnerForm:confirmDeleteButton")
    private GrapheneElement confirmDeleteButton;

    @FindBy(id="deleteOwnerForm:cancelDeleteOwner")
    private GrapheneElement canceDeleteButton;

    @FindBy(id = "findEntityForm:searchButton")
    private GrapheneElement searchButton;

    @FindBy(id = "findEntityForm:clearSearchButton")
    private GrapheneElement clearSearchButton;

    @FindBy(id = "entityDataTableForm:entityDataTable:0:showDetailsFormButton")
    private GrapheneElement showDetailsFormButton0;

    @FindBy(id = "entityDataTableForm:entityDataTable:1:showDetailsFormButton")
    private GrapheneElement showDetailsFormButton1;

    @FindBy(id = "entityDataTableForm:entityDataTable:2:showDetailsFormButton")
    private GrapheneElement showDetailsFormButton2;

    @FindBy(id = "entityDataTableForm:entityDataTable:3:showDetailsFormButton")
    private GrapheneElement showDetailsFormButton3;

    @FindBy(id = "entityDataTableForm:entityDataTable:4:showDetailsFormButton")
    private GrapheneElement showDetailsFormButton4;

    @FindBy(id="detailsOwnerForm:cancelDetailsOwner")
    private GrapheneElement cancelDetailsButton;

    @FindBy(id="detailsOwnerForm:addNewPetButton")
    private GrapheneElement addNewPetButton;

    @FindBy(id="addNewPetForm:cancelButtonAddNewOwnersPet")
    private GrapheneElement cancelNewPetButton;

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:0:addVisitButton")
    private GrapheneElement addVisitToPet0Button;

    @FindBy(id="addVisitForm:cancelAddNewOwnersPetVisit")
    private GrapheneElement cancelNewVisitButton;

    public OwnerPage clickAddNewEntityButton() {
        //Graphene.guardHttp(showNewFormButton).click();
        showNewFormButton.sendKeys(Keys.DOWN);
        showNewFormButton.sendKeys(Keys.END);
        Graphene.guardHttp(showNewFormButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickCancelNewEntityButton() {
        //Graphene.guardHttp(cancelNewButton).click();
        cancelNewButton.sendKeys(Keys.DOWN);
        cancelNewButton.sendKeys(Keys.END);
        Graphene.guardHttp(cancelNewButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickShowEditForm() {
        //Graphene.guardHttp(showEditFormButton).click();
        showEditFormButton.sendKeys(Keys.DOWN);
        showEditFormButton.sendKeys(Keys.END);
        Graphene.guardHttp(showEditFormButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickCancelEditButton() {
        //Graphene.guardHttp(cancelEditButton).click();
        cancelEditButton.sendKeys(Keys.DOWN);
        cancelEditButton.sendKeys(Keys.END);
        Graphene.guardHttp(cancelEditButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickDeleteSelectedButton() {
        //Graphene.guardHttp(deleteSelectedButton).click();
        deleteSelectedButton.sendKeys(Keys.DOWN);
        deleteSelectedButton.sendKeys(Keys.END);
        Graphene.guardHttp(deleteSelectedButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickConfirmDeleteButton() {
        //Graphene.guardHttp(confirmDeleteButton).click();
        confirmDeleteButton.sendKeys(Keys.DOWN);
        confirmDeleteButton.sendKeys(Keys.END);
        Graphene.guardHttp(confirmDeleteButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickCancelDeleteButton() {
        //Graphene.guardHttp(canceDeleteButton).click();
        canceDeleteButton.sendKeys(Keys.DOWN);
        canceDeleteButton.sendKeys(Keys.END);
        Graphene.guardHttp(canceDeleteButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickSearchButton() {
        //Graphene.guardHttp(searchButton).click();
        searchButton.sendKeys(Keys.DOWN);
        searchButton.sendKeys(Keys.END);
        searchButton.sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickClearSearchButton() {
        //Graphene.guardHttp(clearSearchButton).click();
        clearSearchButton.sendKeys(Keys.DOWN);
        clearSearchButton.sendKeys(Keys.END);
        clearSearchButton.sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton0() {
        //Graphene.guardHttp(showDetailsFormButton0).click();
        showDetailsFormButton0.sendKeys(Keys.DOWN);
        showDetailsFormButton0.sendKeys(Keys.END);
        Graphene.guardHttp(showDetailsFormButton0).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public void fullscreen(){
        driver.manage().window().fullscreen();
    }

    public OwnerPage clickShowDetailsFormButton1() {
        Graphene.guardHttp(showDetailsFormButton1).click();
        showDetailsFormButton1.sendKeys(Keys.DOWN);
        showDetailsFormButton1.sendKeys(Keys.END);
        Graphene.guardHttp(showDetailsFormButton1).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton2() {
        //Graphene.guardHttp(showDetailsFormButton2).click();
        showDetailsFormButton2.sendKeys(Keys.DOWN);
        showDetailsFormButton2.sendKeys(Keys.END);
        Graphene.guardHttp(showDetailsFormButton2).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton3() {
        //Graphene.guardHttp(showDetailsFormButton3).click();
        showDetailsFormButton3.sendKeys(Keys.DOWN);
        showDetailsFormButton3.sendKeys(Keys.END);
        Graphene.guardHttp(showDetailsFormButton3).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton4() {
        //Graphene.guardHttp(showDetailsFormButton4).click();
        showDetailsFormButton4.sendKeys(Keys.DOWN);
        showDetailsFormButton4.sendKeys(Keys.END);
        Graphene.guardHttp(showDetailsFormButton4).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickShowDetailsFormButton(int i) {
        switch (i){
            case 0: clickShowDetailsFormButton0(); break;
            case 1: clickShowDetailsFormButton1(); break;
            case 2: clickShowDetailsFormButton2(); break;
            case 3: clickShowDetailsFormButton3(); break;
            case 4: clickShowDetailsFormButton4(); break;
            default: break;
        }
        //fullscreen();
        return this;
    }

    public OwnerPage clickCancelDetailsButton() {
        //Graphene.guardHttp(cancelDetailsButton).click();
        cancelDetailsButton.sendKeys(Keys.DOWN);
        cancelDetailsButton.sendKeys(Keys.END);
        Graphene.guardHttp(cancelDetailsButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickAddNewPetButton() {
        //Graphene.waitModel(driver).until().element(addNewPetButton).is().enabled();
        //Actions action = new Actions(driver);
        //action.moveToElement(addNewPetButton).pause(1000).perform();
        addNewPetButton.sendKeys(Keys.DOWN);
        addNewPetButton.sendKeys(Keys.END);
        Graphene.guardHttp(addNewPetButton).sendKeys(Keys.ENTER);
        //Graphene.guardHttp(addNewPetButton).click();
        //fullscreen();
        return this;
    }

    public OwnerPage clickCancelNewPetButton() {
        //Graphene.waitModel(driver).until().element(cancelNewPetButton).is().enabled();
        cancelNewPetButton.sendKeys(Keys.DOWN);
        cancelNewPetButton.sendKeys(Keys.END);
        Graphene.guardHttp(cancelNewPetButton).sendKeys(Keys.ENTER);
        //Graphene.guardHttp(cancelNewPetButton).click();
        //fullscreen();
        return this;
    }

    public OwnerPage clickAddNewVisitToPet0Button() {
        //Graphene.waitModel(driver).until().element(addNewVisitButton).is().enabled();
        //Actions action = new Actions(driver);
        //action.moveToElement(addNewVisitButton).pause(1000).perform();
        addVisitToPet0Button.sendKeys(Keys.DOWN);
        addVisitToPet0Button.sendKeys(Keys.END);
        Graphene.guardHttp(addVisitToPet0Button).sendKeys(Keys.ENTER);
        //Graphene.guardHttp(addNewVisitButton).click();
        //fullscreen();
        return this;
    }

    public OwnerPage clickCancelNewVisitButton() {
        //Graphene.waitModel(driver).until().element(cancelNewVisitButton).is().enabled();
        //Graphene.guardHttp(cancelNewVisitButton).click();
        cancelNewVisitButton.sendKeys(Keys.DOWN);
        cancelNewVisitButton.sendKeys(Keys.END);
        Graphene.guardHttp(cancelNewVisitButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    @Override
    public boolean isFlowStateList() {
        return OwnerFlowState.LIST.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateDetails() {
        return OwnerFlowState.DETAILS.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateNew() {
        return OwnerFlowState.NEW_OWNER.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateEdit() {
        return OwnerFlowState.EDIT_OWNER.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateDelete() {
        return OwnerFlowState.DELETE_OWNER.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateSearchResult() {
        return OwnerFlowState.LIST_SEARCH_RESULT.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateNewPet() {
        return OwnerFlowState.NEW_PET.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateEditPet() {
        return OwnerFlowState.EDIT_PET.name().compareTo(ownerFlowState.getText())==0;
    }

    @Override
    public boolean isFlowStateNewVisit() {
        return OwnerFlowState.NEW_VISIT.name().compareTo(ownerFlowState.getText())==0;
    }

    public OwnerPage() {
    }

    public OwnerPage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    @FindBy(id="addNewOwnerForm:firstNameAddNewOwner")
    private GrapheneElement newOwnerInputFirstName;

    @FindBy(id="addNewOwnerForm:lastNameAddNewOwner")
    private GrapheneElement newOwnerInputLastName;

    @FindBy(id="addNewOwnerForm:addressAddNewOwner")
    private GrapheneElement newOwnerInputAddress;

    @FindBy(id="addNewOwnerForm:houseNumberAddNewOwner")
    private GrapheneElement newOwnerInputHouseNumber;

    @FindBy(id="addNewOwnerForm:addressInfoAddNewOwner")
    private GrapheneElement newOwnerInputAddressInfo;

    @FindBy(id="addNewOwnerForm:cityAddNewOwner")
    private GrapheneElement newOwnerInputCity;

    @FindBy(id="addNewOwnerForm:zipCodeAddNewOwner")
    private GrapheneElement newOwnerZipCode;

    @FindBy(id="addNewOwnerForm:phoneNumberAddNewOwner")
    private GrapheneElement newOwnerPhoneNumber;

    @FindBy(id="addNewOwnerForm:emailAddNewOwner")
    private GrapheneElement newOwnerEmail;

    @FindBy(id="addNewOwnerForm:saveAddNewOwner")
    private GrapheneElement newOwnerSaveButton;

    public OwnerPage addNewEntity(Owner o) {
        if(null != o.getAddressInfo()){
            newOwnerInputAddressInfo.sendKeys(o.getAddressInfo());
        }
        newOwnerInputFirstName.sendKeys(o.getFirstName());
        newOwnerInputLastName.sendKeys(o.getLastName());
        newOwnerInputAddress.sendKeys(o.getAddress());
        newOwnerInputHouseNumber.sendKeys(o.getHouseNumber());
        newOwnerInputCity.sendKeys(o.getCity());
        newOwnerZipCode.sendKeys(o.getZipCode());
        newOwnerPhoneNumber.sendKeys(o.getPhoneNumber());
        newOwnerEmail.sendKeys(o.getEmail());
        //Graphene.guardHttp(newOwnerSaveButton).click();
        newOwnerSaveButton.sendKeys(Keys.DOWN);
        newOwnerSaveButton.sendKeys(Keys.END);
        Graphene.guardHttp(newOwnerSaveButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    @FindBy(id="editOwnerForm:firstNameEditOwner")
    private GrapheneElement editOwnerInputFirstName;

    @FindBy(id="editOwnerForm:lastNameEditOwner")
    private GrapheneElement editOwnerInputLastName;

    @FindBy(id="editOwnerForm:addressEditOwner")
    private GrapheneElement editOwnerInputAddress;

    @FindBy(id="editOwnerForm:houseNumberEditOwner")
    private GrapheneElement editOwnerInputHouseNumber;

    @FindBy(id="editOwnerForm:addressInfoEditOwner")
    private GrapheneElement editOwnerInputAddressInfo;

    @FindBy(id="editOwnerForm:cityEditOwner")
    private GrapheneElement editOwnerInputCity;

    @FindBy(id="editOwnerForm:zipCodeEditOwner")
    private GrapheneElement editOwnerZipCode;

    @FindBy(id="editOwnerForm:phoneNumberEditOwner")
    private GrapheneElement editOwnerPhoneNumber;

    @FindBy(id="editOwnerForm:emailEditOwner")
    private GrapheneElement editOwnerEmail;

    @FindBy(id="editOwnerForm:saveEditOwner")
    private GrapheneElement editOwnerSaveButton;

    public OwnerPage editNameAddString() {
        String firstName = editOwnerInputFirstName.getText();
        String lastName = editOwnerInputLastName.getText();
        String address = editOwnerInputAddress.getText();
        String houseNumber = editOwnerInputHouseNumber.getText();
        String addressInfo = editOwnerInputAddressInfo.getText();
        String city = editOwnerInputCity.getText();
        String zipCode = editOwnerZipCode.getText();
        String phoneNumber = editOwnerPhoneNumber.getText();
        String email = editOwnerEmail.getText();
        firstName += "Test";
        lastName += "TEST";
        address += " XY";
        houseNumber += " 33";
        if(null != addressInfo){
            addressInfo += " TeST";
            editOwnerInputAddressInfo.sendKeys(addressInfo);
        }
        city += " ZZ";
        zipCode += "99";
        phoneNumber += "77";
        editOwnerInputFirstName.sendKeys(firstName);
        editOwnerInputLastName.sendKeys(lastName);
        editOwnerInputAddress.sendKeys(address);
        editOwnerInputHouseNumber.sendKeys(houseNumber);
        editOwnerInputCity.sendKeys(city);
        editOwnerZipCode.sendKeys(zipCode);
        editOwnerPhoneNumber.sendKeys(phoneNumber);
        editOwnerEmail.sendKeys(email);
        //Graphene.guardHttp(editOwnerSaveButton).click();
        editOwnerSaveButton.sendKeys(Keys.DOWN);
        editOwnerSaveButton.sendKeys(Keys.END);
        Graphene.guardHttp(editOwnerSaveButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    @FindBy(id="addNewPetForm:petNameAddNewOwnersPet")
    private WebElement petNameAddNewOwnersPetInput;

    @FindBy(id="addNewPetForm:petBirthDateAddNewOwnersPet_input")
    private WebElement petBirthDateAddNewOwnersPetInput;

    @FindBy(id="addNewPetForm:petTypeAddNewOwnersPet")
    private WebElement petTypeAddNewOwnersPetDiv;

    @FindBy(id="addNewPetForm:petTypeAddNewOwnersPet_input")
    private Select petTypeAddNewOwnersPetInput;

    @FindBy(id="addNewPetForm:saveButtonAddNewOwnersPet")
    private GrapheneElement newOwnersPetSaveButton;

    private final DateFormat df = DateFormat.getDateInstance(SHORT, Locale.US);

    public OwnerPage clickAddAndSaveNewPet(Pet pet) {
        int option = 1;
        petTypeAddNewOwnersPetDiv.click();
        petNameAddNewOwnersPetInput.sendKeys(pet.getName());
        //petBirthDateAddNewOwnersPetInput.sendKeys("6/9/2014");
        petBirthDateAddNewOwnersPetInput.sendKeys(df.format(pet.getBirthDate()));
        petTypeAddNewOwnersPetInput.selectByIndex(option);
        newOwnersPetSaveButton.sendKeys(Keys.DOWN);
        newOwnersPetSaveButton.sendKeys(Keys.END);
        Graphene.guardHttp(newOwnersPetSaveButton).sendKeys(Keys.ENTER);
        //Graphene.guardHttp(newOwnersPetSaveButton).click();
        //fullscreen();
        return this;
    }

    @FindBy(id="addVisitForm:visitDate_input")
    private WebElement newVisitDateInput;

    @FindBy(id="addVisitForm:visitDescription")
    private WebElement newVisitDescriptionInput;

    @FindBy(id="addVisitForm:saveAddNewOwnersPetVisit")
    private GrapheneElement newVisitSaveButton;

    public OwnerPage clickAddAndSaveNewVisitButton(Date datum, String description) {
        newVisitDateInput.sendKeys(Keys.DOWN);
        newVisitDateInput.sendKeys(Keys.END);
        newVisitDateInput.sendKeys(df.format(datum));
        newVisitDescriptionInput.sendKeys(description);
        //Graphene.guardHttp(newVisitSaveButton).click();
        newVisitSaveButton.sendKeys(Keys.DOWN);
        newVisitSaveButton.sendKeys(Keys.END);
        Graphene.guardHttp(newVisitSaveButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:0:editPetButton")
    private GrapheneElement editOwnersPetShowFormButton0;

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:1:editPetButton")
    private GrapheneElement editOwnersPetShowFormButton1;

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:2:editPetButton")
    private GrapheneElement editOwnersPetShowFormButton2;

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:3:editPetButton")
    private GrapheneElement editOwnersPetShowFormButton3;

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:4:editPetButton")
    private GrapheneElement editOwnersPetShowFormButton4;

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:5:editPetButton")
    private GrapheneElement editOwnersPetShowFormButton5;

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:6:editPetButton")
    private GrapheneElement editOwnersPetShowFormButton6;

    @FindBy(id="detailsOwnerForm:petsAndVisitsTable:7:editPetButton")
    private GrapheneElement editOwnersPetShowFormButton7;

    @FindBy(id="editPetForm:petNameEditOwnersPet")
    private GrapheneElement petNameAddEditedOwnersPetInput;

    @FindBy(id="editPetForm:petBirthDateEditOwnersPet_input")
    private GrapheneElement petBirthDateAddEditedOwnersPetInput;

    @FindBy(id="editPetForm:petTypeEditOwnersPet")
    private WebElement petTypeAddEditedOwnersPetDiv;

    @FindBy(id="editPetForm:petTypeEditOwnersPet_input")
    private Select petTypeAddEditedOwnersPetInput;

    @FindBy(id="editPetForm:saveButtonEditOwnersPet")
    private GrapheneElement editOwnersPetSaveButton;

    @FindBy(id="editPetForm:cancelButtonEditOwnersPet")
    private GrapheneElement editOwnersPetCancelButton;

    public OwnerPage clickSaveEditPetButton() {
        String name = petNameAddEditedOwnersPetInput.getText();
        name += " TeST";
        int option = 2;
        petTypeAddEditedOwnersPetDiv.click();
        //petTypeAddEditedOwnersPetDiv.sendKeys(Keys.DOWN);
        //petTypeAddEditedOwnersPetDiv.sendKeys(Keys.END);
        //Graphene.guardHttp(petTypeAddEditedOwnersPetDiv).sendKeys(Keys.ENTER);
        petNameAddEditedOwnersPetInput.sendKeys(name);
        petBirthDateAddEditedOwnersPetInput.sendKeys("2/3/2012");
        petTypeAddEditedOwnersPetInput.selectByIndex(option);
        editOwnersPetSaveButton.sendKeys(Keys.DOWN);
        editOwnersPetSaveButton.sendKeys(Keys.END);
        Graphene.guardHttp(editOwnersPetSaveButton).sendKeys(Keys.ENTER);
        //fullscreen();
        return this;
    }

    public OwnerPage clickCancelEditedPetButton() {
        //Graphene.guardHttp(editOwnersPetCancelButton).click();
        editOwnersPetCancelButton.sendKeys(Keys.DOWN);
        editOwnersPetCancelButton.sendKeys(Keys.END);
        Graphene.guardHttp(editOwnersPetCancelButton).sendKeys(Keys.ENTER);
        return this;
    }

    public OwnerPage clickShowEditPetForm(int i) {
        switch(i){
            case 0:
                editOwnersPetShowFormButton0.sendKeys(Keys.DOWN);
                editOwnersPetShowFormButton0.sendKeys(Keys.END);
                Graphene.guardHttp(editOwnersPetShowFormButton0).sendKeys(Keys.ENTER);
                //Graphene.guardHttp(editOwnersPetShowFormButton0).click();
                break;
            case 1:
                editOwnersPetShowFormButton1.sendKeys(Keys.DOWN);
                editOwnersPetShowFormButton1.sendKeys(Keys.END);
                Graphene.guardHttp(editOwnersPetShowFormButton1).sendKeys(Keys.ENTER);
                //Graphene.guardHttp(editOwnersPetShowFormButton1).click();
                break;
            case 2:
                editOwnersPetShowFormButton2.sendKeys(Keys.DOWN);
                editOwnersPetShowFormButton2.sendKeys(Keys.END);
                Graphene.guardHttp(editOwnersPetShowFormButton2).sendKeys(Keys.ENTER);
                //Graphene.guardHttp(editOwnersPetShowFormButton2).click();
                break;
            case 3:
                editOwnersPetShowFormButton3.sendKeys(Keys.DOWN);
                editOwnersPetShowFormButton3.sendKeys(Keys.END);
                Graphene.guardHttp(editOwnersPetShowFormButton3).sendKeys(Keys.ENTER);
                //Graphene.guardHttp(editOwnersPetShowFormButton3).click();
                break;
            case 4:
                editOwnersPetShowFormButton4.sendKeys(Keys.DOWN);
                editOwnersPetShowFormButton4.sendKeys(Keys.END);
                Graphene.guardHttp(editOwnersPetShowFormButton4).sendKeys(Keys.ENTER);
                //Graphene.guardHttp(editOwnersPetShowFormButton4).click();
                break;
            case 5:
                editOwnersPetShowFormButton5.sendKeys(Keys.DOWN);
                editOwnersPetShowFormButton5.sendKeys(Keys.END);
                Graphene.guardHttp(editOwnersPetShowFormButton5).sendKeys(Keys.ENTER);
                //Graphene.guardHttp(editOwnersPetShowFormButton5).click();
                break;
            case 6:
                editOwnersPetShowFormButton6.sendKeys(Keys.DOWN);
                editOwnersPetShowFormButton6.sendKeys(Keys.END);
                Graphene.guardHttp(editOwnersPetShowFormButton6).sendKeys(Keys.ENTER);
                //Graphene.guardHttp(editOwnersPetShowFormButton6).click();
                break;
            case 7:
                editOwnersPetShowFormButton7.sendKeys(Keys.DOWN);
                editOwnersPetShowFormButton7.sendKeys(Keys.END);
                Graphene.guardHttp(editOwnersPetShowFormButton7).sendKeys(Keys.ENTER);
                //Graphene.guardHttp(editOwnersPetShowFormButton7).click();
                break;
            default: throw new NoSuchElementException();
        }
        //fullscreen();
        return this;
    }

}
