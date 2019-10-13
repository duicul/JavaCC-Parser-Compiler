package domain;

import java.util.ArrayList;
import java.util.List;

public class Program extends Domain {
    List<Packet> lp = new ArrayList<Packet>();
	public Program(String name) {
	}

	@Override
	public boolean test(String name) {
		for(Packet p : lp)
			if(p.equalname(name))
				return false;
		return true;
	}
	
	public void add(Domain p) {
		lp.add((Packet) p);
	}

	

}
