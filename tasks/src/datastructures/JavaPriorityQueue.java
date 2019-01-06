package datastructures;

import java.util.*;

public class JavaPriorityQueue {
    static class Student{
        private int id;
        private String name;
        private double cgpa;
        public Student(int id, String name, double cgpa) {
            super();
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public double getCgpa() {
            return cgpa;
        }
    }

    static class Priorities {
        List<Student> getStudents(List<String> events) {
            Queue<Student> queue = new PriorityQueue<Student>(10,
                    Comparator.comparing(Student::getCgpa).reversed()
                            .thenComparing(Student::getName)
                            .thenComparing(Student::getId));

            for (String event : events) {
                handleEvent(event, queue);
            }

            List<Student> result = new ArrayList<>();
            while (queue.size() > 0) {
                result.add(queue.poll());
            }
            return result;
        }
    }

    private static class Event {
        boolean isEnter;
        String name;
        double cgpa;
        int id;

        Event(String s) {
            String[] split = s.split(" ", 4);
            if (4 == split.length) {
                this.isEnter = true;
                this.name = split[1];
                this.cgpa = Double.parseDouble(split[2]);
                this.id = Integer.parseInt(split[3]);
            }
        }
    }

    private static void handleEvent(String event, Queue<Student> queue) {
        Event e = new Event(event);
        if (e.isEnter) {
            queue.add(new Student(e.id, e.name, e.cgpa));
        } else {
            queue.poll();
        }
    }

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
