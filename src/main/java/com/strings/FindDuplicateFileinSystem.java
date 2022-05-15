package com.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
    //  ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>(); // content to list of paths
        for(String path : paths) {
            String[] files = path.split(" ");
            String dir = files[0];

            for(int i = 1; i < files.length; i++) {
                String fileName = files[i].substring(0, files[i].indexOf('('));
                String content = files[i].substring(files[i].indexOf('(') + 1, files[i].indexOf(')'));
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(dir + '/' + fileName);
            }

        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                result.add(entry.getValue());
            }
        }

        return result;
    }


    public static void main(String[] args) {
        FindDuplicateFileinSystem findDuplicateFileinSystem = new FindDuplicateFileinSystem();
        findDuplicateFileinSystem.findDuplicate(new String[]{
                "root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"});
    }
}
