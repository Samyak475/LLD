package CostStrategy;

import Entities.Ticket;

import java.time.LocalDateTime;

public class FixedCostStrategy implements CostStrategy{
    @Override
    public  int calculateCost(Ticket ticket){
        LocalDateTime entryTime = ticket.getEntryTime();
        if(LocalDateTime.now().getHour()-(entryTime.getHour())>2){
            return 100;
        }
        else return 50;
    }
}
