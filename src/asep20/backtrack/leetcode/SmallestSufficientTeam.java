package asep20.backtrack.leetcode;

import java.util.*;

//https://leetcode.com/problems/smallest-sufficient-team/
public class SmallestSufficientTeam {

    private final TreeMap<String, List<Integer>> skillCombo = new TreeMap<>();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        for (int i = 0; i < people.size(); i++) {
            for(String skill : people.get(i)) {
                List<Integer> skillPeople = skillCombo.getOrDefault(skill, new ArrayList<>());
                skillPeople.add(i);
                skillCombo.put(skill, skillPeople);
            }
        }

        LinkedList<String> neededSkillz = new LinkedList<>(Arrays.asList(req_skills));

        List<Integer> out = findSmallest(neededSkillz, people);

        return out.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> findSmallest(LinkedList<String> neededSkillz, List<List<String>> people) {
        if (neededSkillz.isEmpty()) {
            return new ArrayList<Integer>();
        }

        String skill = neededSkillz.removeFirst();

        Integer shortest = null;
        List<Integer> shortestList = null;

        for(int person : skillCombo.get(skill)) {
            List<String> removedSkills = new ArrayList<>();
            for(String pSkill : people.get(person)) {
                if(neededSkillz.remove(pSkill)) {
                    removedSkills.add(pSkill);
                }
            }

            List<Integer> otherSkills = findSmallest(neededSkillz, people);
            if(shortest == null || otherSkills.size() < shortest) {
                shortest = otherSkills.size();
                shortestList = otherSkills;
                shortestList.add(person);
            }
            neededSkillz.addAll(removedSkills);
        }

        neededSkillz.add(skill);

        return shortestList;
    }


    public static void main(String[] args) {
        SmallestSufficientTeam sst = new SmallestSufficientTeam();


        sst.smallestSufficientTeam( new String[]{"algorithms","math","java","reactjs","csharp","aws"},
                Arrays.asList(  Arrays.asList("algorithms","math","java") ,
                        Arrays.asList("algorithms","math","reactjs"), Arrays.asList("java","csharp","aws"),
                        Arrays.asList("reactjs","csharp"), Arrays.asList("csharp","math"), Arrays.asList("aws","java"), Arrays.asList("algorithms","reactjs", "math") ));
    }

}
