import java.util.ArrayList;
public class RosterList
{
    private ArrayList<Roster> rosterList;

    public RosterList()
    {
        rosterList = new ArrayList<Roster>();
    }

    public void viewRoster()
    {
        ViewRosterDialog.showDialog(rosterList.toString());
    }

    public boolean enterRoster(Roster newRoster)
    {
        if(newRoster == null)
            ErrorDialog.showDialog("Invalid Roster");
        else
            return rosterList.add(newRoster);
        return false;
    } 

    public boolean removeRoster(Roster remove)
    {
        return rosterList.remove(remove);
    }

    public Roster getStudent(Roster student)
    {
        int index = rosterList.indexOf(student);
        return rosterList.get(index);
    }

    public boolean isEmpty()
    {
        return rosterList.isEmpty();
    }

    public ArrayList<Roster> getList()
    {
        return rosterList;
    }

    public String toString()
    {
        String list = "";
        for(Roster r : rosterList)
            list+=r.toString() + "\n";
        return list;
    }
}
