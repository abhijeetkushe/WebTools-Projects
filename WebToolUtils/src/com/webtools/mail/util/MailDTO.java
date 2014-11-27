package com.webtools.mail.util;

import com.webtools.generic.AbstractDTO;

/**
 *
 * @author Admin
 */
public class MailDTO extends AbstractDTO{


    private String fromAddress;
    private String addressTO;
    private String addressCC;
    private String addressBCC;
    private String mailBody;
    private String subject;

    public String getAddressBCC() {
        return addressBCC;
    }

    public void setAddressBCC(String addressBCC) {
        this.addressBCC = addressBCC;
    }

    public String getAddressCC() {
        return addressCC;
    }

    public void setAddressCC(String addressCC) {
        this.addressCC = addressCC;
    }

    public String getAddressTO() {
        return addressTO;
    }

    public void setAddressTO(String addressTO) {
        this.addressTO = addressTO;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
