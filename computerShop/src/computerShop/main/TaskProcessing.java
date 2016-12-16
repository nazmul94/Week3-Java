package computerShop.main;
import computerShop.models.GeneratedComputers;
import computerShop.models.Computer;

public class TaskProcessing
{
    public static void listAllComputers()
    {
        for(Computer computer : GeneratedComputers.catalogue)
        {
            System.out.println(computer);
        }
    }
}
