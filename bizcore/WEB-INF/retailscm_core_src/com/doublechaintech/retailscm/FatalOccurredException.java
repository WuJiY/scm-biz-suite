
package com.doublechaintech.retailscm;
import com.terapico.BusinessException;
import java.util.ArrayList;
import java.util.List;

public class FatalOccurredException extends RuntimeException{
    public FatalOccurredException() {
        super();
    }

    public FatalOccurredException(String message) {
        super(message);
    }

    public FatalOccurredException(String message, Throwable cause) {
        super(message, cause);
    }

    public FatalOccurredException(Throwable cause) {
        super(cause);
    }

    public FatalOccurredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }



    static final long serialVersionUID = -1;

      @Override
      public String getMessage() {

        String pMessage = super.getMessage();

        if (this.getErrorMessageList().size() <= 0) {
          return pMessage;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (pMessage != null) {
          stringBuilder.append(pMessage).append(':');
        }

        for (Message message : getErrorMessageList()) {
          stringBuilder.append(message.getBody());
        }

        return stringBuilder.toString();
      }

      public FatalOccurredException(Message message) {
        super();
        this.addErrorMessage(message);
      }

      public FatalOccurredException(List<Message> messageList) {
        super();
        this.addErrorMessages(messageList);
      }

      private List<Message> errorMessageList;

      public List<Message> getErrorMessageList() {

        ensureErrorList();

        return errorMessageList;
      }

      public void setErrorMessageList(List<Message> errorMessageList) {
        this.errorMessageList = errorMessageList;
      }

      protected void ensureErrorList() {
        if (errorMessageList == null) {
          errorMessageList = new ArrayList<Message>();
        }
      }

      public void addErrorMessage(Message errorMessage) {
        ensureErrorList();
        errorMessageList.add(errorMessage);
      }

      public void addErrorMessages(List<Message> messageList) {
        ensureErrorList();
        errorMessageList.addAll(messageList);
      }

      public boolean hasErrors() {
        if (errorMessageList == null) {
          return false;
        }
        if (errorMessageList.isEmpty()) {
          return false;
        }
        return true;
      }

}















