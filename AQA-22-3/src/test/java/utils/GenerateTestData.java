package utils;

import io.netty.util.internal.ThreadLocalRandom;

public class GenerateTestData {

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomHobbie() {
        String[] hobbies = {"Music", "Reading", "Sports"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomPicture() {
        String[] pictures = {"picture2.jpg", "screenshot_22-1.png"};
        return getRandomItemFromArray(pictures);
    }


    public static String getRandomUserSubjects(){
       String[] subjects = {"Computer Science", "Biology", "Social Studies", "Maths", "Arts"};
        return getRandomItemFromArray(subjects);
    }
}
