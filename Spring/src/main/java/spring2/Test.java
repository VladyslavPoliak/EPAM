package spring2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spr.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.getVolume() + " " + musicPlayer.getName());

        ClassicalMusic classicalMusic = context.getBean("classicalMusic", ClassicalMusic.class);

        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer == musicPlayer2);

        context.close();
    }

}
