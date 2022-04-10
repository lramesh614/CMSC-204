/**
   Computes average of given data set.
*/
public class DataSetGen<T extends Measurable> 
{
   private T max;
   
   private double sum;
   private int count;

   /**
      Constructs an empty data set.
   */
   public DataSetGen()
   {
	   max = null; sum = 0; count = 0;
   }

   /**
      Average of data that is added.
      @return average or @return 0 if no data added
   */
   @SuppressWarnings({"hiding", "unchecked"})
   public <T extends Measurable> double getAverage()
   {
      if (count == 0) return 0;
      else return sum / count;
   }

   /**
      Gets the largest of the added data.
      @return the maximum or @return 0 if no data added
   */
   @SuppressWarnings({ "hiding", "unchecked" })
   public <T extends Measurable> T getMaximum()
   {
      return (T) max;
   }
   
	   /**
	   Adds a value to data set
	   @param x a data value
	*/
	public <X extends Measurable> void add(T x)
	{
	   sum = sum + x.getMeasure();
	   if (count == 0 || max.getMeasure() < x.getMeasure())
	 	  max = (T) x; 
	   count++;
	}
	
}