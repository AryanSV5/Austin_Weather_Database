// --== CS400 Project One File Header ==--
// Name: Aryan Reddy Permalla
// CSL Username: permalla
// Email: permalla@wisc.edu
// Lecture #: 001 (9:30-10:45)
// Notes to Grader: This is a placeholder class for the Algorithm Engineer

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 
 * A placeholder class for the Algorithm Engineer's implementation of the Red Black Tree data 
 * structure, which builds on top our original implementation of the Red Black tree.
 * 
 * @author Aryan Permalla
 *
 */
public class RangeSearchTreeBD extends RedBlackTree<WeatherInterface>
    implements RangeSearchTreeInterface<WeatherInterface> {
  
    public RangeSearchTreeBD() {
      super();
    }
    /**
     * An iterator which enables us to traverse through each node our tree. This is a placeholder
     * implementation which needs to return our simulated data.
     * 
     */
    public Iterator<WeatherInterface> iterator() {
      List<WeatherInterface> placeHolder = new ArrayList<>();
      WeatherBD placeHolderData1 = new WeatherBD("27/04/2023", 50, 50);
      WeatherBD placeHolderData2 = new WeatherBD("28/04/2023", 56, 57);
      WeatherBD placeHolderData3 = new WeatherBD("29/04/2023", 58, 59);
      WeatherBD placeHolderData4 = new WeatherBD("30/04/2023", 60, 61);
      WeatherBD placeHolderData5 = new WeatherBD("31/05/2023", 70, 77);
      placeHolder.add(placeHolderData1);
      placeHolder.add(placeHolderData2);
      placeHolder.add(placeHolderData3);
      placeHolder.add(placeHolderData4);
      placeHolder.add(placeHolderData5);
     return placeHolder.iterator();
        
    }
    /**
     * This method enables us to remove weather objects to our tree
     * 
     */
    public void removeOne(WeatherInterface data) {
      remove(data);
    }
    /**
     * This method enables us to add weather objects to our tree
     * 
     */
    public void insertOne(WeatherInterface data) {
      insert(data);
    }
    /**
     * This method fetches the number of available nodes within a tree
     * 
     */
    public int getNumberOfNodes() {
      return this.getNumberOfNodes();
    }

}
