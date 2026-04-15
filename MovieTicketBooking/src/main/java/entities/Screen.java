package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Screen {
    private final int screenId;
    private final List<Seat> seatInScreen;
    private final ConcurrentHashMap<LocalDate, List<Shows>>showsAvailableDate = new ConcurrentHashMap<>();

    public List<Seat> getSeatInScreen() {
        return seatInScreen;
    }

    public Screen(List<Seat> seatInScreen, int screenId) {
        this.seatInScreen = seatInScreen;
        this.screenId = screenId;
    }

    public void addShow(Shows show, LocalDate date){
       if(!showsAvailableDate.containsKey(date) ){
           showsAvailableDate.put(date,new ArrayList<>());
       }
       List<Shows> showsList = showsAvailableDate.get(date);
       showsList.add(show);
       showsAvailableDate.put(date,showsList);
    }
    public  void removeShow(Shows shows,LocalDate date){
        showsAvailableDate.get(date).remove(shows);
    }
    public List<Shows> getAvailableShows(LocalDate date){
        return showsAvailableDate.getOrDefault(date,null);
    }


}
