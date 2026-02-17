package CostStrategy;

import Entities.Ticket;

public interface CostStrategy {
    public int calculateCost(Ticket ticket);
}
