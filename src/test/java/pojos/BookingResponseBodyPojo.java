package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponseBodyPojo {

    // 1) Tüm keyler için private variable 'lar oluşturuyoruz.
    private Integer bookingId;
    public BookingPojo booking;

    //    2) Tüm parametrelerle ve parametresiz constructor'larımızı oluşturuyoruz.

    public BookingResponseBodyPojo(Integer bookingId, BookingPojo booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    public BookingResponseBodyPojo() {
    }

//    3) Getters ve Setters'larımızı oluşturuyoruz.

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }


    //    4) toString() methodumuzu oluşturuyoruz.


    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingId=" + bookingId +
                ", booking=" + booking +
                '}';
    }
}
