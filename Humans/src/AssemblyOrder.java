import java.util.Comparator;

public class AssemblyOrder implements Comparator<Human> {

	public int compare(Human human1, Human human2) {
		int comparison = 0;
		if(human1 instanceof WilliamAberhartStudent) {
			if(!(human2 instanceof WilliamAberhartStudent)) {
				comparison = -1;
			}
		}
		else if (human1 instanceof Youth) {
			if (human2 instanceof WilliamAberhartStudent) {
				comparison  = +1;
			}
			else if (!(human2 instanceof Youth)) {
				comparison = -1;
			}
		}
		else if(human1 instanceof Adult) {
			if (human2 instanceof Youth) {
				comparison = +1;
			}
			else if (!(human2 instanceof Adult)) {
				comparison = -1;
			}
		}
		else if (human2 instanceof Adult || human2 instanceof Youth) {
			comparison = +1;
		}
		if (comparison == 0) {
			Comparator<Human> comparator = new NameOrder();
			comparison = comparator.compare(human1,human2);
		}
		return comparison;
	}
}
