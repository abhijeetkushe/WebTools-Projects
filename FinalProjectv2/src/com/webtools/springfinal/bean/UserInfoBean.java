package com.webtools.springfinal.bean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.NotEmpty;

import com.webtools.generic.AbstractDTO;
import com.webtools.html.SelectedItem;
import com.webtools.springfinal.logger.LogMessage;
import com.webtools.springfinal.webview.HtmlOptions;

public class UserInfoBean extends AbstractDTO {

	private SelectedItem[] options=HtmlOptions.getTitleOptions();
	private List<SelectedItem> stateOptions=HtmlOptions.getStateOptions();
	
	@NotEmpty(message="No First name value is entered")
	private String firstName="";
	private String mode;
	private String capthaText;
	/**
	 * @return the capthaText
	 */
	public String getCapthaText() {
		return capthaText;
	}
	/**
	 * @param capthaText the capthaText to set
	 */
	public void setCapthaText(String capthaText) {
		this.capthaText = capthaText;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the options
	 */
	public SelectedItem[] getOptions() {
		return options;
	}
	/**
	 * @param options the options to set
	 */
	public void setOptions(SelectedItem[] options) {
		this.options = options;
	}
	@NotEmpty(message="No Last name value is entered")
	private String lastName="";
	
	private String middleName="";
	private String fullName="";
	private String title="";
	private String gender="M";
	@NotEmpty(message="Please enter the address")
	private String addressLine1="";
	private String addressLine2="";
	@NotEmpty(message="No City value is entered")
	private String city="";
	@NotEmpty(message="No State value is entered")
	private String state="";
	@NotEmpty(message="No ZipCode value is entered")
	private String zipCode="";
	@NotEmpty(message="No Home Phone value is entered")
	private String homephone="";
	private String workphone="";
	private String cellphone="";
	/**
	 * @return the stateOptions
	 */
	public List<SelectedItem> getStateOptions() {
		return stateOptions;
	}
	/**
	 * @param stateOptions the stateOptions to set
	 */
	public void setStateOptions(List<SelectedItem> stateOptions) {
		this.stateOptions = stateOptions;
	}
	private String email="";
	private UserAccountBean userAccount;
	/**
	 * @return the image
	 */
	public Blob getImage() {
		return Hibernate.createBlob(userImage);
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(Blob image) {
		this.userImage=getByteArrayFromBlob(image);
	}
	
	private byte[] getByteArrayFromBlob(Blob image)
	{
		byte[] returnBytes=null;
		try
		{
			byte[] buffer=new byte[4000];
			InputStream is=image.getBinaryStream();
			ByteArrayOutputStream bias=new ByteArrayOutputStream();
			while(-1!=is.read(buffer))
			{	
				bias.write(buffer);
			}	
			returnBytes=bias.toByteArray();
		}
		catch(SQLException e)
		{
			LogMessage.logStackTrace(e);
		} catch (IOException e) {
			LogMessage.logStackTrace(e);
		
		}
		return returnBytes;
	}
	private Long userID=0L;
	private String userType;
	@NotEmpty(message="No userImage value is entered")
	private byte[] userImage;
	@NotEmpty(message="No File Name is entered")
	private String fileName;
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the userImage
	 */
	/*public Blob getUserImage() {
		return userImage;
	}
	*//**
	 * @param userImage the userImage to set
	 *//*
	public void setUserImage(Blob userImage) {
		this.userImage = userImage;
	}*/
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @return the userImage
	 */
	public byte[] getUserImage() {
		return userImage;
	}
	/**
	 * @param userImage the userImage to set
	 */
	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the userID
	 */
	public Long getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Long userID) {
		this.userID = userID;
	}


	public UserAccountBean getUserAccount() {
		return userAccount;
	}
	/**
	 * @param userAccount the userAccount to set
	 */
	public void setUserAccount(UserAccountBean userAccount) {
		this.userAccount = userAccount;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		
		return this.title+" "+this.firstName+" "+this.lastName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the homephone
	 */
	public String getHomephone() {
		return homephone;
	}
	/**
	 * @param homephone the homephone to set
	 */
	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}
	/**
	 * @return the workphone
	 */
	public String getWorkphone() {
		return workphone;
	}
	/**
	 * @param workphone the workphone to set
	 */
	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}
	/**
	 * @return the cellphone
	 */
	public String getCellphone() {
		return cellphone;
	}
	/**
	 * @param cellphone the cellphone to set
	 */
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
