package asep20.backtrack;

import java.util.*;

//https://leetcode.com/problems/smallest-sufficient-team/
public class SmallestSufficientTeamDP {

    Set<String> skills = new HashSet<>();
    Set<Integer>  result = new HashSet<>();
    int resultSize = Integer.MAX_VALUE;

   Set<Set<Integer>> memo = new HashSet<>();

    public void makeTeam(List<Set<String>> people, Set<Integer> skillIndices, int idx) {

        if(memo.contains(skillIndices)) return;
        if(skillIndices.size() > resultSize ) return;

        Set<String> teamSkillSet = new HashSet<>();
        for(Integer skillIdx: skillIndices) {
            teamSkillSet.addAll(people.get(skillIdx));
        }
        if(skills.equals(teamSkillSet)) {
            resultSize = skillIndices.size();
            result = skillIndices;
            memo.add(skillIndices);
            return;
        }

        for (int i = idx; i < people.size() ; i++) {

            if(people.get(i).size() > 0) {
                Set<Integer> temp = new HashSet<>(skillIndices);
                temp.add(i);
                makeTeam(people, temp, idx + 1);
            }
        }

        memo.add(skillIndices);
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        List<Set<String>> peopleSkillSet = new ArrayList<>();
        for(List<String> person: people) {
            peopleSkillSet.add( new LinkedHashSet<>(person));
        }

        List<Set<String>> temp = new ArrayList<>(peopleSkillSet);
        for(Set<String> person: temp) {
            Iterator<Set<String>>  itr =  peopleSkillSet.iterator();
            while(itr.hasNext()) {
                Set<String> next = itr.next();
                if( !person.equals(next)  && person.containsAll(next )) {
                    itr.remove();
                }
            }
        }

        Comparator<Set<String>> skillComparator =  (Set<String> o1, Set<String> o2) -> Integer.compare(o2.size(), o1.size());
        Collections.sort(peopleSkillSet, skillComparator);

        skills.addAll(Arrays.asList(req_skills));
        makeTeam(peopleSkillSet,  new HashSet<Integer>(), 0);
        int[] ans = new int[result.size()];

        int cnt=0;
        for(Integer idx: result) {
            ans[cnt++] = people.indexOf(new ArrayList<>(peopleSkillSet.get(idx)));
           // ans[cnt++] = idx;
        }
        return ans;
    }


    public static void main(String[] args) {
        SmallestSufficientTeamDP sst = new SmallestSufficientTeamDP();


        System.out.println(
                sst.smallestSufficientTeam( new String[]{"algorithms","math","java","reactjs","csharp","aws"},
                Arrays.asList(  Arrays.asList("algorithms","math","java") ,
                        Arrays.asList("algorithms","math","reactjs"), Arrays.asList("java","csharp","aws"),
                        Arrays.asList("reactjs","csharp"), Arrays.asList("csharp","math"), Arrays.asList("aws","java")))
        );
    }

}
