package com.maintec.fincore.util;

import com.maintec.fincore.entity.Branch;
import com.maintec.fincore.entity.ID;
import com.maintec.fincore.entity.User;

public class Util {
   public static Branch getDefaultBranch() {
      Branch branch = new Branch();
      branch.setId(1L);
      return branch;
   }

   public static ID getDefaultParentID() {
      ID parentID = new ID();
      parentID.setId(1L);
      return parentID;
   }

   public static User getDefaultUser() {
      User user = new User();
      user.setId(1L);
      return user;
   }
}
