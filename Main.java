package bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap<String, String[]>();

        graph.put("you", new String[]{"alice", "bob", "claire"});
        graph.put("bob", new String[]{"anuj", "peggy"});
        graph.put("alice", new String[]{"peggy"});
        graph.put("claire", new String[]{"thom", "jonny"});
        graph.put("anuj", new String[]{});
        graph.put("peggy", new String[]{});
        graph.put("thom", new String[]{});
        graph.put("jonny", new String[]{});

        String[] visited = new String[8];

        Queue<String> queue = new LinkedList<String>();
        queue.offer("you"); //добавляем "you" в очередь
        while (!queue.isEmpty()) {

            //System.out.println(queue.peek()); //возвращает без удаления элемент из начала очереди
            String currentElement = queue.peek();
            if (isMangoSeller(currentElement)) {
                System.out.println(currentElement);
                break;
            }
            addToVisited(visited, currentElement); //добавляем проверенный элемент в массив visited


            String[] friends = graph.get(queue.peek()); //в массив записываем всех друзей от текущего элемента из очереди

            for (int i = 0; i < friends.length; i++) { //если элемени из массива еще не был проверен, то его добавляем в очередь
                if (!isVisited(visited, friends[i])) {
                    queue.offer(friends[i]); //добавляем в очередь друзей "you"
                }

            }
            queue.poll(); //возвращает с удалением элемент из начала очереди
            //addToVisited(visited, "Maks");
            //System.out.println(isVisited(visited,"Maks"));

//        System.out.println(queue.peek()); // peek - возвращает без удаления элемент из начала очереди
//        System.out.println(queue.poll()); //poll - возвращает с удалением элемент из начала очереди
//        System.out.println(queue.size()); //size - вернуть размер очереди

        }



//        addToVisited(visited, "Maks");
//        addToVisited(visited, "Maks");
//        System.out.println(Arrays.toString(visited));
    }

    public static void addToVisited(String[] visited, String person) {
        int i = 0;
        while (visited[i] != null) {
            if (i == 7) {
                return;
            }
            i++;
        }
        visited[i] = person;
    }

    public static boolean isVisited(String[] visited, String name) {
        for (int i = 0; i < visited.length; i++) {
            if (name.equals(visited[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMangoSeller(String string) {
        return string.toCharArray()[string.length() - 1] == 'm';
    }
}
