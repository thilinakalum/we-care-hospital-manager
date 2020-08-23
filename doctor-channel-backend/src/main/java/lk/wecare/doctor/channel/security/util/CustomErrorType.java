package lk.wecare.doctor.channel.security.util;

/** @author Kavish Manjitha Perera */
public class CustomErrorType {

  private String errorMessage;

  public CustomErrorType(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
