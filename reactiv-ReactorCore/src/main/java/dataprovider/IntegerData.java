package dataprovider;

import java.util.ArrayList;
import java.util.List;

public class IntegerData implements DataProvider {

	@Override
	public List<Integer> datacreator(Integer maxInt) {
		// TODO Auto-generated method stub
		
		List<Integer> data = new ArrayList<>();
		
		for(int i =0; i<=maxInt;i++) {
			data.add(i);
		}
		
		return data;
	}

}
