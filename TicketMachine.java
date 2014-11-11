/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // Add a boolean to make the machine print tickets with a discount.
    private boolean discount;
   
    /**
     * Create a machine that issues tickets of the given price.
     * You can give a discount with the giveDiscount of a given discount.
     */
    public TicketMachine(int cost, boolean giveDiscount)
    {
        price = cost;
        balance = 0;
        total = 0;
        discount = giveDiscount;
    }

    /**
     * @Return The price of a ticket. If discount is actived, 
     * it return the discounted price
     */
    public int getPrice()
    {
        if (discount == true) {
            int discountPrice;
            discountPrice = (price * 90)/100;
            return discountPrice;
        }
        else {
            return price;
        }
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
    /**
     * Active or disable the discount of 10% when printing a ticket
     */
    public void giveDiscount()
    {
        discount = !discount;
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     * If discount is active, it will print a ticket with a 10% discount.
     */
    public void printTicket()
    {
        
        if (discount == true)
        {
            int discountPrice;
            discountPrice = (price * 90)/100;
            if(balance >= discountPrice)
            {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + discountPrice + " cents.");
                System.out.println("##################");
                System.out.println();

                // Update the total collected with the price.
                total = total + discountPrice;
                // Reduce the balance by the prince.
                balance = balance - discountPrice;
            }
            else 
            {
                // Print the amount of money needed to print a ticket 
                // if discount is applied
                int amountLeftToPay;
                amountLeftToPay = (discountPrice - balance);
                System.out.println("You must insert at least: " +
                               amountLeftToPay + " more cents.");
             }
        }
        else
        {
            System.out.println ("This machine doesnt have discount active.");
            if (balance >= price) 
            {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();

                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
            } 
            else 
            {
                // Print the amount of money needed to print a ticket 
                int amountLeftToPay;
                amountLeftToPay = (price - balance);
                System.out.println("You must insert at least: " +
                               amountLeftToPay + " more cents."); 
            }
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    /**
     * Return the money missing to print the ticket
     */
    public int getAmountLeftToPay()
    {
        int amountLeftToPay;
        amountLeftToPay = (price - balance);
        return amountLeftToPay;
    }
    /**
     * Empty the machine of the money inside
     */
    public int emptyMachine ()
    {
        int moneyInsideTheMachine;
        moneyInsideTheMachine = total;
        total = 0;
        return moneyInsideTheMachine;
    }
}
