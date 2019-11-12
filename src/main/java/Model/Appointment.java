package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private Location location;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Appointment( Location location, LocalDate date, LocalTime startTime, LocalTime endTime){
        this.location = location;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString()
    {
        return String.format("{ location={0}, date={1}, startTime='{2}', endTime='{3}' }",
                location, date, startTime, endTime);
    }
}
