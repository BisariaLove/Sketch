/*
 * Write algorthim to determine the total time to make ice cream and when it leaves the store. 
 * Consist of an order time, order number, and ice cream type. 
 * “ice cream Type” is an integer: 0 for combo, 1 for vanilla. Order numbers are increasing. 
 * 
 * We have three machines for making ice creams. 
 * It takes 45 seconds to make a combo ice cream and 15 for vanilla. Can only make one ice cream at a time. 

 * Need to determine total time to make ice cream and time the ice cream leaves the store (delivered). 
 * 
 * In: order_time,order_num,ice_cream_type 
 * Out: order_num,depart_time,total_time
 * 
 */

public class IcecreamStore {
	Time machine1_lastDeparture;
	Time machine2_lastDeparture;
	Time machine3_lastDeparture;

	public OrderOut makeIcecream(Time orderTime, int orderNum, int icecreamType) {
		Time earliestAvailable = min(machine1_lastDeparture, 
			machine2_lastDeparture, machine3_lastDeparture);

		OrderOut orderOut = new OrderOut();
		if(earlistAvailable <= orderTime) {
			orderOut.departureTime = orderTime 
				+ getTimeToMake(icecreamType);
		}
		else {
			orderOut.departureTime = earlistAvailable 
				+ getTimeToMake(icecreamType);
		}

		updateMachine(earliestAvailable);

		orderOut.totalTime = orderOut.departureTime - orderTime;
		orderOut.orderNum = orderNum

		return orderOut;
	}

	private Time getTimeToMake(int ice) {
		if(ice == 0)
			return new Time(15);
		else 
			return new Time(45);
	}

	private updateMachine(Time t) {
		// update the machine variable which has the lowest value with t. 
		// Because that machine will be used to make this order.
	}
}

class OrderOut {
	int orderNum;
	Time departureTime;
	Time totalTime;
}
