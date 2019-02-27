package com.company;

import java.util.List;
import java.util.Objects;

public class Sect {

    private String leader;

    private String name;

    private List<Member> memebers;

    public Sect(String leader, String name, List<Member> memebers) {
        this.leader = leader;
        this.name = name;
        this.memebers = memebers;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMemebers() {
        return memebers;
    }

    public void setMemebers(List<Member> memebers) {
        this.memebers = memebers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sect sect = (Sect) o;
        return Objects.equals(leader, sect.leader) &&
                Objects.equals(name, sect.name) &&
                Objects.equals(memebers, sect.memebers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leader, name, memebers);
    }




}
