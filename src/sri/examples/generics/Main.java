package sri.examples.generics;

interface Player{
    String name();
}
record BaseballPlayer(String name,String position) implements Player{}

record FootBallPlayer(String name,String position) implements Player{}

record VollyBallPlayer(String name,String position) implements Player{}

public class Main {

    public static void main(String[] args) {
        var philly1=new Affiliation("City","PA","US");
        BaseballTeam phillies1=new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1=new BaseballTeam("Houston Astros");
        scoreResult(phillies1,3,astros1,5);

        SportsTeam phillies2=new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2=new SportsTeam("Houston Astros");
        scoreResult(phillies2,3,astros2,5);

        Team<BaseballPlayer,Affiliation> phillies=new Team<>("Philadelphia Phillies",philly1);
        Team<BaseballPlayer,Affiliation> astros=new Team<>("Houston Astros");
        scoreResult(phillies,3,astros,5);

        var harper = new BaseballPlayer("B Harper", "Right fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right fielder");
        var gatri=new BaseballPlayer("D Guthrie","Center");
        phillies.addTeamMember(gatri);
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();


        SportsTeam afc1=new SportsTeam("Adelaide Crows");
        Team<FootBallPlayer,Affiliation> afc=new Team<>("Adelaide Crows");
        var tex=new FootBallPlayer("Tex walker","Center half forward");
        var rory=new FootBallPlayer("Rory Laird","Mid Field");
        afc.addTeamMember(tex);
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team<VollyBallPlayer,Affiliation> adelide = new Team<>("Adelide Strom");
        adelide.addTeamMember(new VollyBallPlayer("N Roberts","Setter"));
        adelide.listTeamMembers();

        var canberra=new Team<VollyBallPlayer,Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VollyBallPlayer("B Black","Opposite"));
        canberra.listTeamMembers();
        scoreResult(canberra,0,adelide,1);

    }

    public static void scoreResult(BaseballTeam team1,int t1_score,
                                   BaseballTeam team2,int t2_score){
        String message=team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }

    public static void scoreResult(SportsTeam team1,int t1_score,
                                   SportsTeam team2,int t2_score){
        String message=team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }

    public static void scoreResult(Team team1,int t1_score,
                                   Team team2,int t2_score){
        String message=team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }

}

