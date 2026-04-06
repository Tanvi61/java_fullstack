package com.finance.model.enums;

public enum Role {
	 ADMIN,    // Full access: manage users, all records, analytics
	 ANALYST,  // Read all records, create/update own, view analytics
	 VIEWER    // Read own records only

}
