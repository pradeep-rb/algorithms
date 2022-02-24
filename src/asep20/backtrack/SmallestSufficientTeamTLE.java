package asep20.backtrack;

import java.util.*;

//https://leetcode.com/problems/smallest-sufficient-team/
public class SmallestSufficientTeamTLE {

    Set<String> skills = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    int resultSize = Integer.MAX_VALUE;



    public void makeTeam(List<List<String>> people, List<List<String>> teamSkillMatrix, int idx) {
        if(teamSkillMatrix.size() > resultSize ) return;

        Set<String> teamSkillSet = new HashSet<>();
        for(List<String> teamSkill: teamSkillMatrix) {
            teamSkillSet.addAll(teamSkill);
        }
        if(skills.equals(teamSkillSet)) {
            resultSize = teamSkillMatrix.size();
            result = teamSkillMatrix;
            return;
        }

        for (int i = idx; i < people.size() ; i++) {
            List<List<String>> temp = new ArrayList<>(teamSkillMatrix);
            temp.add(people.get(i));
            makeTeam(  people,  temp , idx + 1);
        }
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {



        skills.addAll(Arrays.asList(req_skills));
        makeTeam(people,  new ArrayList<>(), 0);
        int[] ans = new int[result.size()];

        int cnt=0;
        for(List<String> person: result) {
            ans[cnt++] = people.indexOf(person);
        }
        return ans;
    }


    public static void main(String[] args) {
        SmallestSufficientTeamTLE sst = new SmallestSufficientTeamTLE();


        sst.smallestSufficientTeam( new String[]{"algorithms","math","java","reactjs","csharp","aws"},
                Arrays.asList(  Arrays.asList("algorithms","math","java") ,
                        Arrays.asList("algorithms","math","reactjs"), Arrays.asList("java","csharp","aws"),
                        Arrays.asList("reactjs","csharp"), Arrays.asList("csharp","math"), Arrays.asList("aws","java") ));
    }

}
