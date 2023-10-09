package utils;

import io.netty.util.internal.ThreadLocalRandom;

public class GenerateTestData {
    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public String getRandomHobbie() {
        String[] hobbies = {"Music", "Reading", "Sports"};
        return getRandomItemFromArray(hobbies);
    }

    public String getRandomPicture() {
        String[] pictures = {"picture2.jpg", "screenshot_22-1.png"};
        return getRandomItemFromArray(pictures);
    }

    public String getRandomUserSubjects(){
       String[] subjects = {"Computer Science", "Biology", "Social Studies", "Maths", "Arts"};
        return getRandomItemFromArray(subjects);
    }

    public String getRandomCalendarDay(){
        Integer value = getRandomInt(1, 28);
        String calendarDay=value.toString();
        return calendarDay;
    }

    public String getRandomMonth(){
        String[] subjects = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                            "October", "November", "December"};
        return getRandomItemFromArray(subjects);
    }

    public String getRandomYear(){
        Integer value = getRandomInt(1900, 2100);
        String calendarYear=value.toString();
        return calendarYear;
    }

    public String getRandomState(){
        String[] subjects = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromArray(subjects);
    }

    public String getRandomCity(){
        String[] subjects = {"Agra", "Lucknow", "Merrut"};
        return getRandomItemFromArray(subjects);
    }
}
