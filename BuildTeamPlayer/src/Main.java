import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Player> lst = new ArrayList<>();
        PlayerService service = new PlayerService();
        List<Player> rs = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        // Add player
        service.addPlayer(lst,new Player(1,"Dang Van Lam",Position.GK));
        service.addPlayer(lst,new Player(22,"Peter Cech",Position.GK));

        service.addPlayer(lst,new Player(4,"Ramos",Position.DF));
        service.addPlayer(lst, new Player(15,"Vidic",Position.DF));
        service.addPlayer(lst, new Player(33,"Que Ngoc Hai",Position.DF));
        service.addPlayer(lst, new Player(37,"Dinh Trong",Position.DF));
        service.addPlayer(lst, new Player(65,"Trong Hoang",Position.DF));
        service.addPlayer(lst, new Player(72,"Van Hau",Position.DF));

        service.addPlayer(lst, new Player(20,"Nguyen Quang Hai",Position.MF));
        service.addPlayer(lst, new Player(30,"Hung Dung",Position.MF));
        service.addPlayer(lst, new Player(20,"Xavi",Position.MF));
        service.addPlayer(lst, new Player(20,"Iniesta",Position.MF));
        service.addPlayer(lst, new Player(20,"Modric",Position.MF));
        service.addPlayer(lst, new Player(20,"Tony Kross",Position.MF));

        service.addPlayer(lst,new Player(7,"Ronaldo",Position.FW));
        service.addPlayer(lst,new Player(10,"Messi",Position.FW));
        service.addPlayer(lst,new Player(9,"Mbappe",Position.FW));
        service.addPlayer(lst,new Player(11,"Neymar",Position.FW));
        service.addPlayer(lst,new Player(19,"Lewandoski",Position.FW));

        while(true){
            rs.removeAll(rs);
            mainMenu();
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    System.out.println("=== 1 : 1GK - 4DF - 4MF - 2FW ===");
                    List<Player> GK = service.randomChoice(lst, Position.GK, 1);
                    List<Player> DF = service.randomChoice(lst, Position.DF,4);
                    List<Player> MF = service.randomChoice(lst, Position.MF, 4);
                    List<Player> FW = service.randomChoice(lst, Position.FW,2);

                    rs.addAll(GK);
                    rs.addAll(DF);
                    rs.addAll(MF);
                    rs.addAll(FW);

                    // Show
                    service.showPlayer(rs);
                    break;

                case 2:
                    System.out.println("=== 1 : 1GK - 4DF - 3MF - 3FW ===");
                    List<Player> GK1 = service.randomChoice(lst, Position.GK, 1);
                    List<Player> DF1 = service.randomChoice(lst, Position.DF,4);
                    List<Player> MF1 = service.randomChoice(lst, Position.MF, 3);
                    List<Player> FW1 = service.randomChoice(lst, Position.FW,3);

                    rs.addAll(GK1);
                    rs.addAll(DF1);
                    rs.addAll(MF1);
                    rs.addAll(FW1);

                    // Show
                    service.showPlayer(rs);
                    break;

                case 3:
                    System.out.println("=== 1 : 1GK - 3DF - 5MF - 2FW ===");
                    List<Player> GK2 = service.randomChoice(lst, Position.GK, 1);
                    List<Player> DF2 = service.randomChoice(lst, Position.DF,3);
                    List<Player> MF2 = service.randomChoice(lst, Position.MF, 5);
                    List<Player> FW2 = service.randomChoice(lst, Position.FW,2);

                    rs.addAll(GK2);
                    rs.addAll(DF2);
                    rs.addAll(MF2);
                    rs.addAll(FW2);

                    // Show
                    service.showPlayer(rs);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please try again");
                    break;
            }
        }



    }

    public static void mainMenu(){
        System.out.println("===== [MAIN MENU] =====");
        System.out.println("Choice option: ");
        System.out.println("1 : 1GK - 4DF - 4MF - 2FW");
        System.out.println("2 : 1GK - 4DF - 3MF - 3FW");
        System.out.println("3 : 1GK - 3DF - 5MF - 3FW");
        System.out.println("0 : Exit");

    }
}
