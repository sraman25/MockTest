package com.mock.test;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Friend {
	
    private Collection<Friend> friends;
    private String email;
 	boolean  isConnected = false;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friend other = (Friend) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		return true;
	}

	


	public boolean canBeConnected(Friend friend) {
    	
    	Friend aFreind = this.getFriends().stream().collect(Collectors.toList()).get(0);
    	if(friend.equals(this) || friend.equals(aFreind))
    		isConnected= true;
    	else {
    		if(friend.getFriends().size()>1)
    			canBeConnected(friend.getFriends().stream().collect(Collectors.toList()).get(0));
    	}
    	
    	return isConnected;
    
    }
	

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
        Friend d = new Friend("D");
        Friend e = new Friend("E");
        Friend f = new Friend("F");
        a.addFriendship(b);
        b.addFriendship(c);
        c.addFriendship(d);
        d.addFriendship(e);
 
        System.out.println(a.canBeConnected(f));
    }
}