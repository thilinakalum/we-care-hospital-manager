package lk.wecare.doctor.channel.model;

import lombok.Data;

@Data
public class BookingDetailModel {

  private Integer bookingId;
  private Integer bookingNumber;
  private String doctorName;
  private String customerName;
  private String sessionDate;
  private String startTime;
  private String endTime;
}
