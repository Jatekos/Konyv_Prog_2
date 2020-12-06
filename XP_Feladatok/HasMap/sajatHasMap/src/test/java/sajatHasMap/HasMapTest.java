package sajatHasMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

public class HasMapTest {
	@Test
	public void testPutShloudReturneWhitValuWhenKeyIsNotConteins() {
		//Given
		Integer expected = 10;
		int toPutInKey = 8;
		HasMap<Integer, Integer> myMap = new HasMap<>();
					
		//When
		Integer actual= myMap.put(toPutInKey, expected);
		//Then
		assertEquals(expected, actual);
	}
	@Test
	public void testPutandGetShouldGetTheSameValueWhatWasPutInWhitInt() {
		//Given
		Integer expected = 10;
		int toPutInKey = 8;
		HasMap<Integer, Integer> myMap = new HasMap<>();
		
		myMap.put(toPutInKey, expected);
		
		//When
		Integer result = myMap.get(toPutInKey);
		
		//Then
		
		assertEquals(expected, result);
		
	}
		
	@Test
	public void testPutAndGetMoreThanOnePutGiveBackTheRigtGet() {
		//Given
		int[] keys = 	{12,35,43,11,  32,13};
		int[] values = 	{10,12,12,4312,43,21};
		
		int toPutInKey = 11;
		Integer expected= 4312;
		HasMap<Integer, Integer>myMap = new HasMap<>();
		
		//When
		
		for (int i=0; i<values.length;i++) {
			myMap.put(keys[i], values[i]);
		}
		
		System.out.println(myMap.toString());
		
		//Then
		System.out.println(myMap.get(toPutInKey));
		assertEquals(expected , myMap.get(toPutInKey));
		
	}
	/*
	@Test
	public void  testContinesKeyShouldGiveBackFalseWhenTheMapIsEmpty() {
		//Given
		HasMap<Integer, Integer>myMap = new HasMap<>();
		int key = 13;
		//when
		//Then
		assertFalse(myMap.containsKey(key));
	}
	
	@Test 
	public void testContinesKeyShouldGiveBackFalseWhenInTheMapNoMatchingKey() {
				//Given
				int[] values = 	{10,12,12,4312,43,21};
				int[] keys = 	{12,35,43,11,  32,13};
				int key = 1;
				
				HasMap<Integer, Integer>myMap = new HasMap<>();
				
				//When
				
				for (int i=0; i<values.length;i++) {
					myMap.put(keys[i], values[i]);
				}
				
				
				
				//Then
				assertFalse(myMap.containsKey(key));
	}
	
@Test
	
	public void testContinesKeyShouldGiveBackTrueForGoodKey() {
		//Given
		int[] values = 	{10,12,12,4312,43,21};
		int[] keys = 	{12,35,43,11,  32,13};
		boolean isItWorking;
		
		HasMap<Integer, Integer>myMap = new HasMap<>();
		
		//When
		
		for (int i=0; i<values.length;i++) {
			myMap.put(keys[i], values[i]);
		}
		
		
		
		//Then
		
		isItWorking = myMap.containsKey(43);
		
		assertTrue(isItWorking);
		}
	
	@Test
	
	public void testContinesKeyShouldGiveBackTrueForAllGoodKey() {
		//Given
		int[] values = 	{10,12,12,4312,43,21};
		int[] keys = 	{12,35,43,11,  32,13};
		boolean isItWorking=true;
		
		HasMap<Integer, Integer>myMap = new HasMap<>();
		
		//When
		
		for (int i=0; i<values.length;i++) {
			myMap.put(keys[i], values[i]);
		}
		
		
		
		//Then
		for (int i:keys) {
			if ( !myMap.containsKey(i))
			isItWorking=false;
		}
		
		
		assertTrue(isItWorking);
		}
	
	@Test
	public void testEqualsShuoldGiveBackTrueWhenItIsTheSame() {
		//Given
				int[] values = 	{10,12,12,4312,43,21};
				int[] keys = 	{12,35,43,11,  32,13};
				
				
				HasMap<Integer, Integer>underTest = new HasMap<>();
				
		//When
				
				for (int i=0; i<values.length;i++) {
					underTest.put(keys[i], values[i]);
				}
		//Then
		assertTrue(underTest.equals(underTest));
		
		
		
	}
	
	@Test 
	public void testEqualsShuoldGiveBackFalseWhenOtherIsNull() {
		//Given
		int[] values = 	{10,12,12,4312,43,21};
		int[] keys = 	{12,35,43,11,  32,13};
		
		HasMap<Integer,Integer> other = null;
		
		HasMap<Integer, Integer>underTest = new HasMap<>();
		
		//When
				
				for (int i=0; i<values.length;i++) {
					underTest.put(keys[i], values[i]);
				}
		//Then
		assertFalse(underTest.equals(other));
	}
	
	@Test
	public void testEqualsShuoldGiveBackTrueWhenTheRootIsNull() {
		//Given
	
		
		HasMap<String,Integer> other = new HasMap<>();
		
		HasMap<Integer, Integer>underTest = new HasMap<>();
		
		//When
				
				
		//Then
		assertTrue(underTest.equals(other));
	}
	
	@Test
	public void testEqualsShuoldGiveBackFalseWhenTheKeyTypeDoesNotMatch() {
		//Given
	
		
		HasMap<String,Integer> other = new HasMap<>();
		
		HasMap<Integer, Integer>underTest = new HasMap<>();
		
		//When
		other.put("a", 10);
		underTest.put(1,1);
				
		//Then
		assertFalse(underTest.equals(other));
	}
	
	@Test
	public void testEqualsShuoldGiveBackFalseWhenTheValueTypeDoesNotMatch() {
		//Given
	
		
		HasMap<Integer,String> other = new HasMap<>();
		
		HasMap<Integer, Integer>underTest = new HasMap<>();
		
		//When
		other.put(10,"a");
		underTest.put(1,1);
				
		//Then
		assertFalse(underTest.equals(other));
	}
	
	@Test
	public void testEqualsShouldGiveBackFalseWhenTheSizeIsNotTheSame() {
		//Given
		int[] values = 	{10,12,12,4312,43,21,101};
		int[] keys = 	{12,35,43,11,  32,13,1};
		
		int[] valuesOther = 	{10,12,12,4312,43,21};
		int[] keysOther = 		{12,35,43,11,  32,13};
		
		HasMap<Integer,Integer> other = new HasMap<>();
		
		HasMap<Integer, Integer>underTest = new HasMap<>();
		
		//When
				
		for (int i=0; i<values.length;i++) {
			underTest.put(keys[i], values[i]);
		}
		for (int i=0; i<valuesOther.length;i++) {
			other.put(keysOther[i], valuesOther[i]);
		}
		//Then
		assertFalse(underTest.equals(other));
	}
	
	@Test 
	public void testEqualsShuoldGiveBackFalseWhenOtherIsNotTheSame() {
		//Given
		int[] values = 	{10,12,12,4312,43,21};
		int[] keys = 	{12,35,43,11,  32,13};
		
		int[] valuesOther = 	{10,12,12,4312,43,213};
		int[] keysOther = 		{12,35,43,11,  32,13};
		
		HasMap<Integer,Integer> other = new HasMap<>();
		
		HasMap<Integer, Integer>underTest = new HasMap<>();
		
		//When
				
		for (int i=0; i<values.length;i++) {
			underTest.put(keys[i], values[i]);
		}
		for (int i=0; i<valuesOther.length;i++) {
			other.put(keysOther[i], valuesOther[i]);
		}
		//Then
		assertFalse(underTest.equals(other));
	}
	
	@Test
	public void testEqualsShuoldGiveBackTrueWhenTheyEquals() {
		//Given
		int[] values = 	{10,12,12,4312,43,21};
		int[] keys = 	{12,35,43,11,  32,13};
		
		
		
		HasMap<Integer,Integer> other = new HasMap<>();
		
		HasMap<Integer, Integer>underTest = new HasMap<>();
		
		//When
				
				for (int i=0; i<values.length;i++) {
					underTest.put(keys[i], values[i]);
				}
				for (int i=0; i<values.length;i++) {
					other.put(keys[i], values[i]);
				}
		//Then
		assertTrue(underTest.equals(other));
	}
	
	@Test
	public void testHashCodeShouldGiveBackTheSameValueForEqualsObjects() {
		//Given
		int[] values = 	{10,12,12,4312,43,21};
		int[] keys = 	{12,35,43,11,  32,13};
		
		int otherHash ;
		int underTestHash ;
		
		HasMap<Integer,Integer> other = new HasMap<>();
		
		HasMap<Integer, Integer>underTest = new HasMap<>();
		
		//When
				
		for (int i=0; i<values.length;i++) {
			underTest.put(keys[i], values[i]);
		}
		for (int i=0; i<values.length;i++) {
			other.put(keys[i], values[i]);
		}
		
		otherHash = other.hashCode();
		underTestHash = underTest.hashCode();
		
		//Then
		assertEquals(otherHash, underTestHash);
	}
	
	@Test
	public void testContinesValueShouldGiveBackTrueWhenValueIsInTheMap() {
		//Given
		int[] values = 	{10,12,12,4312,43,21};
		int[] keys = 	{12,35,43,11,  32,13};
		int value = 21 ;
		HasMap<Integer,Integer> map = new HasMap<>();
		//When
		for (int i=0; i<values.length;i++) {
			map.put(keys[i], values[i]);
		}
		//Then
		
		assertTrue(map.containsValue(value));
		
		
	}
	
	@Test
	public void testContinesValueShouldGiveBackFalseWhenValueIsNotInTheMap() {
		//Given
		int[] values = 	{10,12,12,4312,43,21};
		int[] keys = 	{12,35,43,11,  32,13};
		int expected = values.length ;
		HasMap<Integer,Integer> map = new HasMap<>();
		//When
		for (int i=0; i<values.length;i++) {
			map.put(keys[i], values[i]);
		}
		//Then
		
		assertEquals(expected, map.size());
		
		
	}
	
	@Test
	public void testIsEmptyShouldGiveBackFalseWhenIsItNotEmpty() {
		//Given
		int[] values = 	{10,12,12,4312,43,21};
		int[] keys = 	{12,35,43,11,  32,13};
		
		HasMap<Integer,Integer> map = new HasMap<>();
		//When
		for (int i=0; i<values.length;i++) {
			map.put(keys[i], values[i]);
		}
		//Then
		
		assertFalse(map.isEmpty());
	}
	
	@Test
	public void testIsEmptyShouldGiveBackTrueWhenIsItEmpty() {
		//Given
		
		
		HasMap<Integer,Integer> map = new HasMap<>();
		//When
		
		//Then
		
		assertTrue(map.isEmpty());
	}
	
	@Test
	public void testKeySetShouldGiveBackASetWhatContinsAllTheKeys() {
		
		//Given
		int[] values = 	{10,12,12,4312,43,21};
		int[] keys = 	{12,35,43,11,  32,13};
		
		HashSet<Integer> expected = new HashSet<Integer>();
		HasMap<Integer,Integer> map = new HasMap<>();
		//When
		for (int i=0; i<values.length;i++) {
			map.put(keys[i], values[i]);
			expected.add(keys[i]);
		}
		//Then
		
		assertEquals(expected, map.keySet());
		
		
	}
	
	@Test
	public void testPutAllShouldPuttInTheSettAllElementOfAAnoterMap() {
		
		//Given
		int[] valuesActual = 	{10,12,12,4312,43,21};
		int[] keysActual = 		{12,35,43,11,  32,13};
		int[] valueAdd  = 		{5,3,4};
		int[] keysAdd = 		{1,2,3};
		int[] valuesExpected = 	{5,3,4,10,12,12,4312,43,21};
		int[] keysExpected = 	{1,2,3,12,35,43,11,  32,13};
		
		//HasMap<Integer,Integer> expected = new HasMap<>();
		HasMap<Integer,Integer> actual = new HasMap<>();
		HasMap<Integer,Integer> add = new HasMap<>();
		/*
		 * for (int i=0; i<keysExpected.length;i++) {
			expected.put(keysExpected[i], valuesExpected[i]);
		}
		*//*
		for (int i=0; i<keysActual.length;i++) {
			actual.put(keysActual[i], valuesActual[i]);
		}
		for (int i=0; i<keysAdd.length;i++) {
			add.put(keysAdd[i], valueAdd[i]);
		}		
		
		//When
		actual.putAll(add);
		
		//Then
		
		boolean isItWorking=true;
		
		for (int i=0; i<keysExpected.length;i++) {
			
			if(actual.containsKey(keysExpected[i])) {
				
				if(valuesExpected[i] != actual.get(keysExpected[i])) {
					isItWorking = false;
				}
			}else {
				isItWorking = false;
			}
		}
		
		
		assertTrue(isItWorking);
	
	}
	
	@Test
	public void testValuesShouldGiveBackACollectionWhatIsContiensAllValues() {
			//Given
			int[] valuesActual = 	{10,12,12,4312,43,21};
			int[] keysActual = 		{12,35,43,11,  32,13};
			HasMap<Integer,Integer> actual = new HasMap<>();
			
			for (int i=0; i<keysActual.length;i++) {
				actual.put(keysActual[i], valuesActual[i]);
			}
			
			Collection<Integer>expected =new ArrayList<Integer>();
			
			for (int i=keysActual.length-1; i>=0;i--) {
				expected.add(valuesActual[i]);
			}
			
			//When
			
			//Then
			assertEquals(expected, actual.values());
			
	}
	
	@Test 
	public void testPutShouldGiveBackNullWhenTheKeyIsAlredyTaken() {
		//Given
		int[] valuesActual = 	{10,12,12,4312,43,21};
		int[] keysActual = 		{12,35,43,11,  32,13};
		int key = keysActual[2];
		int value = 10;
		HasMap<Integer,Integer> actual = new HasMap<>();
		
		for (int i=0; i<keysActual.length;i++) {
			actual.put(keysActual[i], valuesActual[i]);
		}
		//When
		//Then
		assertNull(actual.put(key, value));
	}

	@Test
	public void testRemoveShouldGiveBackTheValueThatWasRemove() {
		//Given
				int[] valuesActual = 	{10,12,12,4312,43,21};
				int[] keysActual = 		{12,35,43,11,  32,13};
				int key=keysActual[3];
				int value= valuesActual[3];
				
				//HasMap<Integer,Integer> expected = new HasMap<>();
				HasMap<Integer,Integer> actual = new HasMap<>();
				HasMap<Integer,Integer> add = new HasMap<>();
				/*
				 * for (int i=0; i<keysExpected.length;i++) {
					expected.put(keysExpected[i], valuesExpected[i]);
				}
				*//*
				for (int i=0; i<keysActual.length;i++) {
					actual.put(keysActual[i], valuesActual[i]);
				}
		//When
				
		//Then
			assertTrue(value == actual.remove(key));
		
				

	}
	
	@Test
	
	public void testRemoveShouldRemoveTheRightElement() {
		//Given
				int[] valuesActual = 	{10,12,12,4312,43,21};
				int[] keysActual = 		{12,35,43,11,  32,13};
				int key=keysActual[3];
				int value= valuesActual[3];
				int[] valuesExcpeted = 		{10,12,12,43,21};
				int[] keysExcpeted = 		{12,35,43,  32,13};
				
				//HasMap<Integer,Integer> expected = new HasMap<>();
				HasMap<Integer,Integer> actual = new HasMap<>();
				HasMap<Integer,Integer> expected = new HasMap<>();
				
				 for (int i=0; i<keysExcpeted.length;i++) {
					expected.put(keysExcpeted[i], valuesExcpeted[i]);
				}
				
				for (int i=0; i<keysActual.length;i++) {
					actual.put(keysActual[i], valuesActual[i]);
				}
		//When
				actual.remove(key);
				
		//Then
			assertEquals(expected, actual);
	}
	
	@Test 
	public void testRemoveShouldGiveBackNullIftheKeyDoseNotInTheMap() {
		//Given
		int[] valuesActual = 	{10,12,12,4312,43,21};
		int[] keysActual = 		{12,35,43,11,  32,13};
		HasMap<Integer,Integer> actual = new HasMap<>();
		int key=1;
		
		for (int i=0; i<keysActual.length;i++) {
			actual.put(keysActual[i], valuesActual[i]);
		}
		//When
		//Then
		assertNull(actual.remove(key));
		
	}

	@Test
	public void testToString() {
		//Given
		int[] keysActual = 		{12,35,43,11,  32,13};
		int[] valuesActual = 	{10,12,12,4312,43,21};
		
		HasMap<Integer,Integer> actual = new HasMap<>();
		
		for (int i=0; i<keysActual.length;i++) {
			actual.put(keysActual[i], valuesActual[i]);
		}
		//When
		System.out.println(actual.toString());
		//Then
		assertTrue(true);
		
	}
*/
}
