import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PlayerService {

    // Add player
    public void addPlayer(List<Player>lst , Player p) {
        lst.add(p);
    }

    // Show list player
    public void showPlayer(List<Player>lst){
        lst.forEach(p-> System.out.println(p));
    }

    // Random choice
    public List<Player> randomChoice(List<Player>lst, Position postion, int numPlayers){
            Random rd = new Random();
            List<Player> lst_copy = new ArrayList<>();
            List<Player> rs = new ArrayList<>();
            lst_copy.addAll(lst);
            int cnt=0;

            List<Player> choice = lst.stream().filter(p->p.getPosition() == postion).collect(Collectors.toList());

            while(cnt<numPlayers){
//                System.out.println(choice.size());
                Player p = choice.get(rd.nextInt(choice.size()));
                rs.add(p);
                choice.remove(p);
                cnt++;
            }

            return rs;
    }


}
