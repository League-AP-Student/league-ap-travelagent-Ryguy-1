import java.util.ArrayList;
import java.util.List;

public class Trip {
	private List<Flight> flights;

	public int getDuration() {

		if(flights.size() == 0) {
			return 0;
		}
		
		Time t1 = flights.get(0).getDeparturetime();
		Time t2 = flights.get(flights.size()-1).getArrivalTime();
		return t1.minutesUntil(t2);
		}

	public int getShortestLayover() {
		if(flights.size()<2) {
			return -1;
		}
		
		
		ArrayList<Integer> layovers = new ArrayList<Integer>(flights.size()-1);
		
		for (int i = 0; i < flights.size()-1; i++) {
			Time t1 = flights.get(i).getArrivalTime();
			Time t2 = flights.get(i+1).getDeparturetime();
			layovers.add(t1.minutesUntil(t2));
		}
		int temp = layovers.get(0);
		for (int i = 0; i < layovers.size(); i++) {
			
			if(temp>layovers.get(i)) {
				temp=layovers.get(i);
			}
		}
		return temp;
		
	}
}
