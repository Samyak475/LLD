import controllers.BookingController;
import controllers.TheatreController;
import entities.*;
import enums.City;
import enums.MovieType;
import enums.SeatType;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MovieBookingSystem {
    private  BookingController bookingController;
    private  TheatreController theatreController;
    public static void main(String []args){
        MovieBookingSystem movieBookingSystem = new MovieBookingSystem();
        movieBookingSystem.intialiseBooking();
        movieBookingSystem.userFlow();
    }
    private void userFlow(){
        System.out.println("Welcome to Movie Booking Application");
        User user1 = new User(1);
        User user2 = new User(2);
        System.out.println("User logged in is "+user1.getId()+" by Name Samyak");
        System.out.println("City Selected is "+ City.DELHI);
        LocalDate localDate = LocalDate.now();
        System.out.println("Date selected is "+ localDate);
        Set<Movie> moviesAvailable = theatreController.getMovie(localDate,City.DELHI);

        System.out.println("Movie Available ");
        moviesAvailable.forEach(movie -> System.out.println(" -- "+movie.getMovieType()));
        Movie selectedMovie = moviesAvailable.iterator().next();
        System.out.println("Selected movie is "+ selectedMovie.getMovieType());

        List<Theatre>availableInTheatre = theatreController.getTheatre(City.DELHI,selectedMovie,localDate);
        System.out.println("This movie is available in theatre -->");
        availableInTheatre.forEach(theatre -> System.out.println(" -- "+theatre.getName()));

        Theatre selectedTheatre = availableInTheatre.get(0);
        System.out.println("Selected Theatre is "+selectedTheatre.getName());

        List<Shows>screensAvailable = theatreController.getShowDetails(selectedTheatre,selectedMovie,localDate);
        System.out.println("Following shows are available for This movie in this theatre --- ");
        screensAvailable.forEach(shows -> System.out.println("-- "+shows.getStartDate()+"----"+shows.getStartTime()));
        Shows selectedShow = screensAvailable.get(0);
        System.out.println("Show selected is "+selectedShow.getStartDate()+" --- "+selectedShow.getStartTime());

        List<Integer> selectedSeats = List.of(1, 2, 3);
        System.out.println("Selected Seats: " + selectedSeats);

        // 10. Booking + Payment
        Booking booking =
                bookingController.book(selectedSeats,user1,selectedShow);

        System.out.println("BOOKING SUCCESSFUL");
        System.out.println("Booking ID: " + booking.getBookingId());

    }
    private void intialiseBooking(){
        bookingController = new BookingController();
        theatreController = new TheatreController();



        Movie movie1 = new Movie(MovieType.K2,2);
        Movie movie2 = new Movie(MovieType.AVENGERS,3);
        Movie movie3 = new Movie(MovieType.DHURANDHAR,4);

       List<Seat> seatList =  initialiseSeat(40);
        Screen screen1 = new Screen(seatList,1);
        seatList = initialiseSeat(60);
        Screen screen2 = new Screen(seatList,2);
        seatList = initialiseSeat(60);
        Screen screen3 = new Screen(seatList,3);



        LocalDate  localDate1 = LocalDate.now();
//        LocalDate  localDate2 = LocalDate.ofEpochDay(04042024);
//        System.out.println(" "+localDate2);
        Shows shows1 = new Shows(movie1,screen1,localDate1, LocalTime.now());
        Shows shows2 = new Shows(movie1,screen2,localDate1, LocalTime.NOON);
        Shows shows3 = new Shows(movie1,screen1,localDate1, LocalTime.MIDNIGHT);
        Shows shows4 = new Shows(movie2,screen2,localDate1, LocalTime.MIDNIGHT);
        Shows shows5 = new Shows(movie3,screen1,localDate1, LocalTime.NOON);
        Shows shows6 = new Shows(movie2,screen3,localDate1, LocalTime.MIDNIGHT);

        screen1.addShow(shows1,localDate1);
        screen2.addShow(shows2,localDate1);
        screen1.addShow(shows3,localDate1);
        screen2.addShow(shows4,localDate1);
        screen1.addShow(shows5,localDate1);
        screen2.addShow(shows5,localDate1);
        screen3.addShow(shows5,localDate1);

        Theatre theatre1= new Theatre(City.DELHI, Arrays.asList(screen1,screen2),"KKM");
        Theatre theatre2= new Theatre(City.DELHI, Arrays.asList(screen1,screen3),"KKMBooking");

        theatreController.addTheatre(theatre1);
        theatreController.addTheatre(theatre2);


    }
    private List<Seat> initialiseSeat(int n){
        List<Seat>seatList = new ArrayList<>();
        for(int i=0;i<n;i++){
            SeatType seatType ;
            if(i<n/3){
                seatType=SeatType.SILVER;
            }else if(i<2*n/3){
                seatType=SeatType.GOLD;
            }else seatType = SeatType.PLATINUM;

            Seat seat= new Seat(i,seatType);
            seatList.add(seat);
        }
         return seatList;
    }
}


