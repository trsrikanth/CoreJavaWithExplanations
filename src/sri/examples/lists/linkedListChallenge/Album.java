package sri.examples.lists.linkedListChallenge;

import java.util.ArrayList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs =new ArrayList<>();
    }

    public boolean addSong(String title,double duration){
        for(Song s:songs){
            if(s.getTitle().equalsIgnoreCase(title)){
                return Boolean.FALSE;
            }
        }
        songs.add(new Song(title,duration));
        return Boolean.TRUE;
    }

    public Song findSong(String title){
        for(Song s:songs){
            if(s.getTitle().equalsIgnoreCase(title)){
                return s;
            }
        }
       return null;
    }


}
