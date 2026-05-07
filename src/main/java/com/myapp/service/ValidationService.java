package com.myapp.service;

import com.myapp.model.ContactInfo;

public class ValidationService {

    public ValidationService(){}

    public String validateContact(ContactInfo contactInfo)
    {
        String nameError = isValidName(contactInfo.getName());
        if (nameError != null){return nameError;}

        String addressError = isValidAddress(contactInfo.getAddress());
        if (addressError != null){return addressError;}

        String phoneNumberError = isValidPhoneNumber(contactInfo.getPhoneNumber());
        if (phoneNumberError != null){return phoneNumberError;}

        String emailError = isValidEmail(contactInfo.getEmail());
        if (emailError != null){return emailError;}

        // validates successfully :)
        return null;
    }

    private String isValidName(String testName)
    {
        if (testName == null || testName.trim().isEmpty())
        {
            return "Name cannot be empty.";
        }

        testName = testName.trim();

        int minLength = 2;
        int maxLength = 40;
        if (testName.length() < minLength || testName.length() > maxLength)
        {
            return "Name must be longer than 2 characters and shorter than 40 characters.";
        }
        boolean result = testName.matches("[a-zA-Z\\s'-]+");

        if (result)
        {
            return null;
        }else
        {
            return "Name is invalid";
        }
    }
    private String isValidAddress(String testAddress)
    {
        if (testAddress == null || testAddress.trim().isEmpty())
        {
            return "Address cannot be empty.";
        }

        testAddress = testAddress.trim();

        boolean cleanedAddress = testAddress.matches("\\d+\\s+[A-Za-z0-9\\s.,'-]+");

        if (!cleanedAddress)
        {
            return "Address is not valid.";
        }

        return null;
    }
    private String isValidPhoneNumber(String testPhoneNumber)
    {
        if (testPhoneNumber == null || testPhoneNumber.trim().isEmpty())
        {
            return "Phone number cannot be empty.";
        }

        testPhoneNumber = testPhoneNumber.trim();

        String cleanedPhone = testPhoneNumber.replaceAll("[^0-9]", "");

        if (cleanedPhone.length() != 10)
        {
            return "Invalid phone number.";
        }
        return null;
    }
    private String isValidEmail(String testEmail)
    {
        if (testEmail == null || testEmail.trim().isEmpty())
        {
            return "Email cannot be empty.";
        }

        testEmail = testEmail.trim();

        boolean cleanedEmail = testEmail.matches(".+@.+\\..+");

        if (!cleanedEmail)
        {
            return "Email did not meet standards.";
        }
        return null;
    }

}
