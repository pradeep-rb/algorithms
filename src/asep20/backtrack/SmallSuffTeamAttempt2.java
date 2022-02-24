package asep20.backtrack;

import java.util.*;
import java.util.stream.Collectors;

public class SmallSuffTeamAttempt2 {

    int smallCount = Integer.MAX_VALUE;
    Map<String,  List<Integer>> skillsPeopleMap = new LinkedHashMap<>();
    List<String>  allSkills;
    Set<Integer> smallestTeam = new HashSet<>();
    Set<Set<Integer>> memo = new HashSet<>();

    public void  computeSST( List<String> skills, Set<Integer>  currTeam, List<Set<String>> people) {

        if(memo.contains(currTeam)) return;
        if(currTeam.size() >= smallCount) return;

        if(skills.size() == 0 ) {
            smallCount = currTeam.size();
            smallestTeam = currTeam;
            memo.add(currTeam);
            return;
        }

        for(String skill: skills) {
            for (Integer personIdx : skillsPeopleMap.get(skill)) {
                List<String> skillsRem = new ArrayList<>(skills);
                skillsRem.remove(skill);

                for (String otherSkill : people.get(personIdx)) {
                    skillsRem.remove(otherSkill);
                }
                Set<Integer> newTeam = new HashSet<>(currTeam);
                newTeam.add(personIdx);
                computeSST(skillsRem, newTeam, people);
            }

        }
        memo.add(currTeam);
    }


    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        List<Set<String>> peopleList= people.stream().map( i -> new HashSet<>(i)).collect(Collectors.toList());

        for (int i = 0; i < peopleList.size(); i++) {
            for (int j = 0; j < peopleList.size(); j++) {
                if(i != j) {
                    if(peopleList.get(i).equals(peopleList.get(j)) ||
                            peopleList.get(i).containsAll(peopleList.get(j))) {
                        peopleList.set(j, new HashSet<>());
                    }
                }
            }
        }

       // peopleList = peopleList.stream().filter(l -> l.size() > 0).collect(Collectors.toList());

        allSkills =  Arrays.stream(req_skills).collect(Collectors.toList());

        for (Set<String> skills: peopleList) {
            for(String skill: skills) {
                skillsPeopleMap.computeIfAbsent(skill, k -> new ArrayList<>()).add(peopleList.indexOf(skills));
            }
        }
        computeSST(  allSkills,  new HashSet<>(), peopleList);
        return  smallestTeam.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        SmallSuffTeamAttempt2 sst = new SmallSuffTeamAttempt2();

//        sst.smallestSufficientTeam( new String[]{"algorithms","math","java","reactjs","csharp","aws"},
//                Arrays.asList(  Arrays.asList("algorithms","math","java") ,
//                        Arrays.asList("algorithms","math","reactjs"), Arrays.asList("java","csharp","aws"),
//                        Arrays.asList("reactjs","csharp"), Arrays.asList("csharp","math"), Arrays.asList("aws","java")));

            sst.smallestSufficientTeam(new String[]{"hfkbcrslcdjq","jmhobexvmmlyyzk","fjubadocdwaygs","peaqbonzgl","brgjopmm","x","mf","pcfpppaxsxtpixd","ccwfthnjt","xtadkauiqwravo","zezdb","a","rahimgtlopffbwdg","ulqocaijhezwfr","zshbwqdhx","hyxnrujrqykzhizm"}
,
                Arrays.asList(
                        Arrays.asList("peaqbonzgl","xtadkauiqwravo"),Arrays.asList("peaqbonzgl","pcfpppaxsxtpixd","zshbwqdhx"),Arrays.asList("x","a"),Arrays.asList("a"),Arrays.asList("jmhobexvmmlyyzk","fjubadocdwaygs","xtadkauiqwravo","zshbwqdhx"),Arrays.asList("fjubadocdwaygs","x","zshbwqdhx"),Arrays.asList("x","xtadkauiqwravo"),Arrays.asList("x","hyxnrujrqykzhizm"),Arrays.asList("peaqbonzgl","x","pcfpppaxsxtpixd","a"),Arrays.asList("peaqbonzgl","pcfpppaxsxtpixd"),Arrays.asList("a"),Arrays.asList("hyxnrujrqykzhizm"),Arrays.asList("jmhobexvmmlyyzk"),Arrays.asList("hfkbcrslcdjq","xtadkauiqwravo","a","zshbwqdhx"),Arrays.asList("peaqbonzgl","mf","a","rahimgtlopffbwdg","zshbwqdhx"),Arrays.asList("xtadkauiqwravo"),Arrays.asList("fjubadocdwaygs"),Arrays.asList("x","a","ulqocaijhezwfr","zshbwqdhx"),Arrays.asList("peaqbonzgl"),Arrays.asList("pcfpppaxsxtpixd","ulqocaijhezwfr","hyxnrujrqykzhizm"),Arrays.asList("a","ulqocaijhezwfr","hyxnrujrqykzhizm"),Arrays.asList("a","rahimgtlopffbwdg"),Arrays.asList("zshbwqdhx"),Arrays.asList("fjubadocdwaygs","peaqbonzgl","brgjopmm","x"),Arrays.asList("hyxnrujrqykzhizm"),Arrays.asList("jmhobexvmmlyyzk","a","ulqocaijhezwfr"),Arrays.asList("peaqbonzgl","x","a","ulqocaijhezwfr","zshbwqdhx"),Arrays.asList("mf","pcfpppaxsxtpixd"),Arrays.asList("fjubadocdwaygs","ulqocaijhezwfr"),Arrays.asList("fjubadocdwaygs","x","a"),Arrays.asList("zezdb","hyxnrujrqykzhizm"),Arrays.asList("ccwfthnjt","a"),Arrays.asList("fjubadocdwaygs","zezdb","a"),Arrays.asList(),Arrays.asList("peaqbonzgl","ccwfthnjt","hyxnrujrqykzhizm"),Arrays.asList("xtadkauiqwravo","hyxnrujrqykzhizm"),Arrays.asList("peaqbonzgl","a"),Arrays.asList("x","a","hyxnrujrqykzhizm"),Arrays.asList("zshbwqdhx"),Arrays.asList(),Arrays.asList("fjubadocdwaygs","mf","pcfpppaxsxtpixd","zshbwqdhx"),Arrays.asList("pcfpppaxsxtpixd","a","zshbwqdhx"),Arrays.asList("peaqbonzgl"),Arrays.asList("peaqbonzgl","x","ulqocaijhezwfr"),Arrays.asList("ulqocaijhezwfr"),Arrays.asList("x"),Arrays.asList("fjubadocdwaygs","peaqbonzgl"),Arrays.asList("fjubadocdwaygs","xtadkauiqwravo"),Arrays.asList("pcfpppaxsxtpixd","zshbwqdhx"),Arrays.asList("peaqbonzgl","brgjopmm","pcfpppaxsxtpixd","a"),Arrays.asList("fjubadocdwaygs","x","mf","ulqocaijhezwfr"),Arrays.asList("jmhobexvmmlyyzk","brgjopmm","rahimgtlopffbwdg","hyxnrujrqykzhizm"),Arrays.asList("x","ccwfthnjt","hyxnrujrqykzhizm"),Arrays.asList("hyxnrujrqykzhizm"),Arrays.asList("peaqbonzgl","x","xtadkauiqwravo","ulqocaijhezwfr","hyxnrujrqykzhizm"),Arrays.asList("brgjopmm","ulqocaijhezwfr","zshbwqdhx"),Arrays.asList("peaqbonzgl","pcfpppaxsxtpixd"),Arrays.asList("fjubadocdwaygs","x","a","zshbwqdhx"),Arrays.asList("fjubadocdwaygs","peaqbonzgl","x"),Arrays.asList("ccwfthnjt")
                ));



//        sst.smallestSufficientTeam( new String[]{"java","nodejs","reactjs"},
//                Arrays.asList(  Arrays.asList("java") ,
//                        Arrays.asList("nodejs"), Arrays.asList("nodejs","reactjs")));
    }
}
