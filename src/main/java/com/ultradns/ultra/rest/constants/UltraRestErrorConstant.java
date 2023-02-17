/**
 * Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package com.ultradns.ultra.rest.constants;

/**
 * Ultra Rest Error.
 *
 * @author nupadhyay
 */
public enum UltraRestErrorConstant {

    INVALID_ZONE_TYPE(53001, "Invalid zone type"),
    INVALID_PRIMARY_NAME_SERVER(53002, "Invalid primary name server"),
    INVALID_METHOD_NAME(53003, "Invalid primary zone create type."),
    INVALID_ZONE_CREATE_TYPE(53004, "Invalid primary zone create type."),
    INVALID_INPUT(53005, "Invalid input: "),
    BEAN_VALIDATION_EMPTY_LIST_ERROR(53006, " must not be empty."),
    ERROR_EXPORT_ZONE_SIZE_LIMIT_EXCEEDED(53007, "The provided number of zones (%d) exceeds allowed limit (%d)"),
    NOT_FOUND_TASK_STATUS(54001, "Cannot find the task status for the input taskId"),
    NOT_FOUND_TASK_INFO(54002, "Cannot find the task info for the input taskId"),
    NOT_ALLOWED_TASK_STATUS_CONVERSION(54003,
            "Illegal Operation: Conversion of TaskStatus to TaskStatusInfo is not allowed."),
    TASK_NOT_COMPLETE(54004, "Invalid task status; Task not yet completed"),
    BEAN_VALIDATION_ERROR(55001, " is required field."),
    BEAN_VALIDATION_FIELD_CAN_NOT_BE_ZERO(55001, " is required field and can not be zero."),
    INVALID_ISO_8601_DATE_TIME_FORMAT(55003,
            "The date format is not valid. Expected a date in ISO 86601 format, but received: "),
    NOT_FOUND_RR_DATA(56001, "Cannot find resource record data for the input zone, record type and owner combination."),
    PARSE_CLOB_DATA(57001, "Unable to get length of clob."),
    CONVERT_TO_CLOB_DATA(57002, "Error while converting the existing record string to clob."),
    CONVERT_FROM_CLOB_HEX_DATA(57003, "Error while converting the existing record clob to hex string."),
    ENCODING_EXCEPTION(58001, "Encoding exception"),
    NOT_FOUND_WEB_FWD(59001, "Cannot find any web forward for the given zone."),
    NOT_FOUND_WEB_FWD_GUID(59002, "Web forward with given guid does not exist under the zone."),
    BAD_WEB_FWD_UPLOAD(59003, "Web forward uploaded in incorrect format."),
    BAD_WEB_FWD_ROW(59004, "Expected 3 values in row, but instead found "),
    BAD_WEB_FWD_REDIRECT_TYPE(59005, "Invalid redirect type: "),
    CANNOT_UNALIAS_SUSPENDED_ZONE(59006, "Can not unalias the suspended zone "),
    ADV_WEB_FWD_REDIRECT_TO_NOT_UNIQUE(59007,
            "All the advanced web forwards should have unique destination of the redirect."),
    INVALID_WEB_FWD_TARGET_URL(59008, "The target URL is either incorrect or doesn't contains supported protocol."),
    NO_PAYLOAD_ERROR(59009, "Payload in this request is required."),
    NO_PRIMARY_USER_ACCOUNT(59010, "No primary user under the account ."),

    // Auth Exception
    AUTH_INVALID_GRANT(60001, "Invalid Grant"),
    AUTH_USER_INACTIVE(60002, "User not Active"),
    AUTH_INVALID_BEARER_TOKEN_FORMAT(60003, "Token format expected is in header is \"Token: Bearer <token>\""),
    AUTH_HEADER_NOT_FOUND(60004, "Authorization Header required"),
    GRANT_TYPE_NOT_SUPPORTED(60005, "grant_type not supported"),
    AUTH_INVALID_REQUEST(60006, "invalid request"),
    AUTH_INVALID_REQUEST_USERNAME_REQUIRED(60007,
            "invalid_request:username parameter is required for grant_type=password"),
    AUTH_INVALID_REQUEST_PASSWORD_REQUIRED(60008,
            "invalid_request:password parameter is required for grant_type=password"),
    AUTH_INVALID_REQUEST_REFRESH_TOKEN_REQUIRED(60009,
            "invalid_request:refresh_token parameter is required for grant_type=refresh_token"),
    AUTH_INVALID_OTHER(60010, "Problem with authentication"),
    AUTH_INVALID_MASQ_CREDS(60011, "Invalid Masquerade Credentials"),
    LOGIN_EXCEPTION(60012, "Login Exception"),
    BLACKLISTED_USER(60013,
            "You are currently blacklisted, please contact UltraDNS customer support at +1 (844) 929-0808 "
                    + "or dns.ultraproducts.support."),
    AUTH_INVALID_SMS2FA_REQUEST_USERNAME_REQUIRED(60014,
            "invalid_request:username parameter is required for grant_type=SMS2FA"),
    AUTH_INVALID_SMS2FA_REQUEST_2FA_TOKEN_REQUIRED(60015,
            "invalid_request:two_factor_auth_token parameter is required for grant_type=SMS2FA"),
    AUTH_INVALID_SMS2FA_REQUEST_TOKEN_REQUIRED(60016,
            "invalid_request:token parameter is required for grant_type=SMS2FA"),
    AUTH_INVALID_RESEND2FA_REQUEST_USERNAME_REQUIRED(60017,
            "invalid_request:username parameter is required for grant_type=RESEND2FA"),
    AUTH_INVALID_RESEND2FA_REQUEST_TOKEN_REQUIRED(60018,
            "invalid_request:token parameter is required for grant_type=RESEND2FA"),

    NOT_FOUND_MAIL_FWD(61001, "Cannot find any mail forward for given zone and email address combination."),
    TOO_MANY_MAIL_FWD(61002, "Found more than one mail forward for a given zone and email address combination"),

    /**
     * Custom HTTP header not found error.
     */
    HEADER_NOT_FOUND(70001, "Header not found."),
    DATA_NOT_FOUND(70002, "Data not found."),
    MAIL_BLOCKER_NOT_FOUND_EXCEPTION(70003, "Mail blocker not found for the input zone and mail address."),
    INVALID_SORT_OPTION(70004, "Invalid sort option: "),
    RDPOOL_VALIDATION_RR_TYPE(70004, "Profile is only applicable for A or AAAA type resource record."),
    RDPOOL_VALIDATION_RR_DATA(70005, "At least one field must be specified: rdata or profile"),
    RDPOOL_VALIDATION_OWNER(70006, "No pool data found for owner: "),
    RDPOOL_INVALID_PROFILE_ORDER(70007, "Given Profile Order is not valid."),
    INVALID_PROFILE_KEY(70008, "Invalid profile key"),
    UPLOADED_FILE_EXCEPTION(70009, "One file must be specified: json or file"),
    ZONE_PROFILE_NOT_FOUND(70010, "Zone profile info not found."),
    RDATA_GUIDS_VALIDATION(70011, "At least one value for rdataGuids is required"),
    RDATA_GUIDS_ZONE_VALIDATION(70012, "Resource record with guid '%s' does not belongs to zone '%s'."),

    /**
     * Account-level Directional Groups.
     */
    DIR_GROUP_NOT_FOUND(80001, "Cannot find any directional group for the given group name"),
    ISO_CODE_NOT_FOUND(80002, "ISO code not found: "),
    IP_LIST_IS_EMPTY(80003, "IP list is empty or null."),
    ONE_OF_THE_FIELD_MUST_SPECIFIED(80004,
            "Only one of the following fields can be specified: address, cidr, startIP."),
    GEO_LIST_IS_EMPTY(80005, "Geo list is empty or null."),
    INVALID_CIDR_NOTATION(80007,
            "Invalid cidr notation. Address must be a valid IPv4 or IPv6 address, followed by a slash(\"/\"), "
                    + "followed by an integer value (1-32 inclusive for IPv4, 1-128 inclusive for IPv6)."),
    END_IP_ADDRESS_REQUIRED(80008, "End IP address should also be provided along with start IP address."),
    INVALID_IPV4_CIDR_NOTATION(80009,
            "Invalid cidr notation. Address must be a valid IPv4 address, followed by a slash(\"/\"), "
                    + "followed by an integer value (1-32 inclusive for IPv4)."),
    ACCOUNT_GROUP_RECORDS_NOT_FOUND(80010, "Cannot find any records assigned to this group."),
    /**
     * Zones Directional Pool errors.
     */
    DIR_POOL_INVALID_PROFILE_RDATA_INFO(90001, "For a Directional Pool, one entry of profile rData info "
            + "should always be provided for each entry in rdata."),
    DIR_POOL_INVALID_UPDATE_INFO_PROFILE_INFO_REQUIRED(90002,
            "Profile information is also required, if a non-existing record is "
                    + "provided and Directional Pool already exists for the given owner"),
    DIR_POOL_INVALID_ASSIGN_EXISTING(90003,
            "The value provided for the field 'isExistingGroupFromPool' " + "for the group '%s' is not valid."),
    DIR_POOL_CANNOT_FORCE_EVERLAP(90004,
            "Cannot force overlapping territories from other forceOverlap and/or accountLevel groups: %s"),
    // SLB POOL related errors
    SLB_POOL_LIVE_RECORD_REQUIRED(90005, "Atleast provide one primary record value"),
    SLB_POOL_RECORD_COUNT(90006, "SLB pool should not have more than five primary records."),
    SLB_POOL_RECORD_INFO_SIZE_MISMATCH(90007, "SLB pool needs to have the same number of rdataInfo as rdata."
            + " Use empty {} as a placeholder for default rdataInfo."),
    SLB_POOL_RR_DATA_VALIDATION(10013, "The IP address specified for the primary record(s) is invalid."),

    // SF POOL related errors
    SF_POOL_PROFILE_REQUIRED(100001, "Profile information is required"),
    SF_POOL_BACKUP_RECORD_REQUIRED(100002, "Backup Record information is required"),
    SF_POOL_MONITOR_REQUIRED(100003, "Monitor information is required"),
    SF_POOL_REGION_FAILURE_SENSITIVITY_REQUIRED(100004, "Region Failure Sensitivity is required"),
    SF_POOL_INVALID_RECORD_STATE(10005, "Allowed Record states are FORCED_INACTIVE or NOT_FORCED"),
    SF_POOL_MONITOR_INVALID(100006, "Url and method in monitor are mandatory fields"),
    SF_POOL_INVALID(100009, "Profile information is not correctly formatted"),
    SF_POOL_INVALID_LIVE_RECORDS(100010, "SF Pool can contain only 1 live record"),
    DIR_POOL_TO_SF_POOL_CONVERSION_NOT_ALLOWED(100011,
            "A Directional Pool cannot be converted to a Simple Failover pool"),
    SF_POOL_CONVERSION_NOT_SUPPORTED(100012,
            "Only A Records, RD Pools and SLB Pools can be converted to Simple Failover pool"),
    DIR_POOL_CONVERSION_NOT_ALLOWED(100013,
            "Cannot convert any pool into Directional Pool and Directional Pool into any other pool"),
    SLB_TO_SF_CONVERSION_MULTIPLE_RECORDS(100014, "SLB pool contains multiple live records. "
            + "Specify the live record that needs to be kept for converting to SF Pool"),

    // common errors valid across different pools
    FAILOVER_RECORD_RDATA_REQUIRED(110001, "rdata information in Failover record is required."),
    MONITOR_METHOD_REQUIRED(110002, "Monitor Method is required."),
    MONITOR_URL_REQUIRED(110003, "Monitor Url is required."),
    INVALID_PROFILE_INFORMATION(110004, "Given profile information is not valid."),
    INVALID_CHAR_IN_SEARCH(110005, "Invalid character '%s' in search query."),
    ERROR_IN_BATCH_OPERATION(110006, "Error in batch operation."),
    SB_POOL_INVALID_PROFILE_RDATA_INFO(110007, "For a Site Backer Pool, one entry of profile rData "
            + "info should always be provided for each entry in rdata."),
    INVALID_PRIORITY(110008, "Invalid Priority : Priority value must be greater than 0 and less than 100000"),
    TC_POOL_INVALID_PROFILE_RDATA_INFO(110009, "For a Traffic Controller Pool, one entry of profile "
            + "rData info should always be provided for each entry in rdata."),
    SBTC_POOL_EVENT_INVALID_FIELD_REPEAT_END(110010,
            "For creating an event, either both the fields repeat and end date or none should be specified."),
    SBTC_POOL_EVENT_PAST_START_DATE(110011, "The event start date must be in the future."),
    SBTC_POOL_EVENT_END_DATE_PRIOR_TO_START_DATE(110012, "The event end date must be after the start date."),
    SBTC_POOL_POOL_RECORD_NOT_FOUND(110013, "Cannot find SB or TC pool record for the given owner."),
    SBTC_INPUT_EXISTING_PROBES_DOES_NOT_MATCH(110014,
            "Existing probe type doesn't match with the probe type for the given values"),
    SBTC_POOL_WEIGHT_INVALID(110015, "For a Traffic Controller Pool, weight must be an even integer between 2 to 100."),
    POOL_RECORD_SPECIFIED_TO_RETAIN_DURING_DELETE_DOES_NOT_EXIST_IN_POOL(110016,
            "The Record specified to be kept does not exist in the pool"),
    SBTC_POOL_EVENT_PAST_END_DATE(110017, "The event end date must be in future."),
    ERROR_MISSING_URI_IN_BATCH(110018, "The batch operation does not have a URI"),
    ERROR_MISSING_METHOD_IN_BATCH(110019, "The batch operation does not have a Method"),
    ERROR_NULL_BATCH_REQUEST(110020, "The batch or batch operation is null"),
    ERROR_BATCH_SIZE_LIMIT_EXCEEDED(110021, "The batch of size %d exceeds size limit (%d)"),
    ERROR_BATCH_METHOD_NOT_ALLOWED(110022, "Invalid request method provided; method '%s' is not allowed."),
    TEST_PROBE_INVALID_RESPONSE(115001, "Invalid response from Probe Controller"),

    // Transfer Acl error codes
    INVALID_IP_RESTRICTION(120001, "One of (startIP,endIP), cidr or singleIP is required to be set in %s[%d]"),
    INVALID_CIDR_CONTENT(120002, "The contents of provided CIDR '%s' are not valid in %s[%d].cidr"),
    INVALID_IPRANGE_FAMILY(120003,
            "'%s' and '%s' must belong to same IP family (IPv6 or IPv4) in %s[%d].(startIP,endIP)"),
    INVALID_IPRANGE(120004, "endIP '%s' must be equal or grater than startIP '%s' in %s[%d].(startIP,endIP)"),
    HOST_NAME_NOT_ALLOWED(120005, "Host name '%s' not allowed as '%s' in %s[%d]"),
    INVALID_TSIG_KEYNAME(120006, "The TSIG key name '%s' is not valid in %s.tsigKeyName"),
    INVALID_TSIG_KEYVALUE(120007, "The TSIG key value '%s' is not valid in %s.tsigKeyValue"),
    INVALID_RESTRICT_IP(120009, "The IP '%s' is not valid '%s' in %s[%d]"),
    INVALID_NOTIFY_IP(120010, "The IP '%s' is not valid '%s' in %s[%d].notifyAddress"),
    OVERLAPPING_RESTRICT_IP_RANGE(120011,
            "The existing IP range '%s' is overlapping with IP range in %s.restrictIPList[%d]"),
    OVERLAPPING_INPUT_RESTRICT_IP_RANGE(120012, "The IP range %s[%d] is overlapping with IP range %s[%d]"),
    INVALID_DESCRIPTION_LENGTH(120013, "The length of '%s' is more than 256 characters"),
    OVERLAPPING_RESTRICT_IP(120014, "The existing IP range '%s' is overlapping with IP range '%s'"),

    ACCOUNT_ACL_ALREADY_EXISTS(120015, "The transfer acl already exists for the account"),
    INVALID_ACCOUNT_ACL_CREATE_REQUEST(120016,
            "The request must contain atleast one of restrictIPList, tsig or notifyAddresses"),
    INVALID_INHERIT_VALUE(120017, "The value '%s' specified for the field 'zone.primaryCreateInfo.inherit' "
            + "is invalid. Please follow the specification of inherit in user manual"),
    INVALID_INHERIT_COMBINATION(120018,
            "The combination of values specified for the field 'zone.primaryCreateInfo.inherit' "
                    + "is invalid. Please follow the specification of inherit in user manual"),
    ACCOUNT_ACL_NOT_FOUND(120019, "The transfer acl does not exist for the account"),
    INVALID_ACCOUNT_ACL_PUT_REQUEST(120020,
            "The request must contain atleast one of restrictIPList, tsig or notifyAddresses. "
                    + "If you want to delete account level ACL, please use DELETE API."),
    INVALID_ACCOUNT_ACL_UPDATE_REQUEST(120021, "The transfer acl does not exist for the account. "
            + "Please use CREATE API to configure account level transfer ACL."),

    // Errors in add pool level probe
    REQUEST_VALID_ONLY_FOR_SBTC_POOL(130001,
            "Data request can only be made for a Sitebacker or Traffic Controller Pool."),
    SBTC_POOL_PROBE_ID_NOT_BELONGING_TO_POOL(130002,
            "The requested Pool Probe does not belong to the Pool for the specified zone and owner."),
    INVALID_URL(130009, "Invalid URL."),
    POOL_PROBE_THRESHOLD(130010, "Threshold can not be 0 or greater than number of agents."),
    SBTC_INVALID_PROBE_DETAILS(130012, "Given probe details is not valid."),
    SBTC_POOL_NOT_FOUND(130014, "Cannot find pool for the given owner."),
    SB_AGENT_NOT_VALID(130016, "Agent '%s' is not valid for account '%s'."),
    SB_PROBE_INAVLID_EXPECTED_RESPONSE_VALUE(130017,
            "Please enter a valid HTTP Response code value between 2XX and 3XX. If you selected the Advanced Option, "
                    + "multiple HTTP codes must be valid and separated by a '|'."),
    SB_PROBE_INVALID_EXPECTED_RESPONSE_RANGE(130018, "Please enter a valid HTTP Response code between 100 and 599."),

    INVALID_CONVERSION(150014, "Invalid conversion: Can not convert from '%s' to '%s'."),
    SB_TC_INVALID_RECORD_STATE_RUN_PROBE_ENABLED(150015,
            "Invalid State: State can not be Normal when actOnProbes is disabled and runProbes is enabled."),
    SB_TC_INVALID_RECORD_STATE_RUN_PROBE_DISABLED(150016,
            "Invalid State: State can not be Active or Inactive when actOnProbes and runProbes are disabled."),
    SBTC_ADD_PROBE_NOTIFICATION_EVENT_FOR_A_SUB_POOL_NOT_ALLOWED(150017,
            "Adding a probe, notification, or event for a sub-pool is not allowed."),
    CONVERSION_NOT_ALLOWED_VIA_PATCH(150018,
            "Conversion for traffic services pools are not allowed via PATCH API. Please use PUT API for the same."),
    NOTIFICATION_NOT_FOUND(160001, "Notification not found."),

    // Error constants for JSON-PATCH operation
    JSON_PATCH_ERROR_IN_PATCH(170001, "Error in applying patch: "),
    JSON_PATCH_JSON_NODE_IS_REQUIRED(170002, "Json node is a required field."),
    JSON_PATCH_INVALID(170003, "Invalid JSON patch."),
    JSON_PATCH_UNSUPPORTED_OPERATION_TYPE(170004, "Unsupported operation type."),

    // DNSSEC error message
    DNSSEC_ZONE_IS_NOT_SIGNED(180001, "Zone is not signed."),
    DNSSEC_ZONE_IS_ALREADY_SIGNED(180002, "Zone is already signed."),
    // Smart search error messages
    SMART_SEARCH_KIND_NOT_SUPPORT(200001, "Kind not supported."),
    SMART_SEARCH_ACCOUNT_OR_ZONE_PROVIDED(200002, "Zone name or account name must be provided."),
    SMART_SEARCH_MAX_LIMIT(200003, "Results contains more than 1000 records."),
    SMART_SEARCH_INVALID_FILTER(200004, "Invalid filter '%s'."),

    // Lab access errors
    LAB_NOT_AVAILABLE(210001, "This lab is not available to this account."),
    LAB_CANNOT_DISABLE(210002, "This lab cannot be disabled for this account. %s"),
    LAB_CANNOT_ENABLE(210003, "This lab cannot be enabled for this account. %s"),

    // PCAP Reporting errors
    PCAP_LIMIT_REACHED(220001, "There are no more PCAP Reports available to this account today."),

    ALIAS_ZONE_CANNOT_BE_UPDATED(230000, "Alias zone cannot be updated"),
    RESTRICT_IP_RANGE_OVERLAPPING(230001, "The IP range %s is overlapping " + "with IP range %s"),

    // Agari errors
    AGARI_ZONES_EDIT_LIST_IS_EMPTY(230001, "_dmarc status edit list is empty or null."),
    AGARI_ZONE_EDIT_NAME_IS_NULL(230002, "Zone name is required."),
    AGARI_ZONE_EDIT_ENABLE_IS_NULL(230003, "_dmarc status edit: 'enable' is required."),
    AGARI_ZONE_EDIT_NOT_ELIGIBLE(230004, "Zone '%s' is not eligible for _dmarc status change."),
    AGARI_ZONE_EDIT_UNAVAILABLE(230005, "Zone '%s' is not available for enabling/disabling Agari."),
    AGARI_ZONE_EDIT_DELETE_FAILED(230006, "Failed to delete record %s while disabling Agari: %s."),

    // HTTP Code errors
    INVALID_ACCEPT_TYPE(240001, "Invalid Accept header: must be application/json or application/xml"),
    INVALID_CONTENT_TYPE(240002, "Invalid Content-Type header: must be application/json or application/xml"),
    INVALID_METHOD_TYPE(240003, "Invalid HTTP Method: This endpoint does not allow the specified method."),

    // Adaptive Response Pool Related errors
    AR_POOL_RECORD_INVALID_A_RECORD(250001, "Invalid A record: must be a valid IPv4 address."),
    AR_POOL_CONFIGURATION_NAME_NOT_SUPPORTED(250002, "Non-default configuration name is not supported yet."),
    AR_POOL_RDATA_INFO_SIZE_MISMATCH(250003, "For AR pool, rdata in rrSet and records in profile must be one-to-one."),
    AR_POOL_RECORD_TYPE_REQUIRED(250004, "Type is required for each record."),
    AR_POOL_ALL_FAIL_RECORD_RDATA_TYPE_REQUIRED(250005, "Rdata and Type are required for each all-fail record."),
    AR_POOL_RECORD_REQUIRED(250006, "At least one live record is required in each AR Pool."),
    AR_POOL_RDATA_INFO_INVALID_OP(250007,
            "Invalid to remove/add rdataInfo without removing/adding corresponding rdata."),

    // Users invite errors
    USERS_INVITE_CANNOT_READ(260001, "This account is not available."),
    // no info 404 when no read permissions
    USERS_INVITE_INVALID_GROUP(260002, "Group %s is invalid for account %s."),
    USERS_INVITE_AMBIGUOUS_GROUP(260003, "Group %s is ambiguous for account %s."),
    USERS_INVITE_WRONG_NUMBER_OF_MODELS(260004, "Unexpected number of models."),
    USERS_INVITE_MODEL_IS_NULL(260005, "Model is null."),
    USERS_INVITE_UNEXPIRED_INVITATION(260005, "Unexpired invitation exists for %s"),
    USERS_INVITE_NO_PENDING_INVITATION(260006, "This account does not have any pending invitations."),
    USERS_INVITE_NO_EMAIL_INVITATION(260007, "Pending invitation does not exists for %s"),
    USERS_INVITE_CANNOT_DELETE_INVITATION(260008, "You do not have permission to delete invitations."),
    USERS_INVITE_EXPIRED_INVITATION(260009,
            "The invitation has expired or invalid - Please ask invitee user to resent the invitation."),
    USERS_INVITE_OWNER_CANNOT_ADDED_TO_GROUP(260010,
            "Account Owner cannot be added to a group."),
    USERS_INVITE_SSO_USER_CANNOT_EXIST_IN_MULTIPLE_ACCOUNT(260011,
            "The account to which you are invited "
                    + "doesn't permit a user to be already associated with same or different account. "
                    + "Please register as a new user."),

    // Security Preferences errors
    INVALID_SECURITY_QUESTION_ID(270001,
            "Invalid value for Security Question. Valid value lies between 1 to 12 (Including both)."),
    INVALID_PASSWORD_EXPIRATION(270002, "Invalid value for Password Expiration. Valid values are 0, 30, 90, 180, 365."),
    NON_UNIQUE_SECURITY_QUESTION(270003, "All three security questions must be different."),
    INVALID_INACTIVE_TIMEOUT(270004, "Invalid value for Inactive Timeout. Valid values are 0, 5, 10, 15, 30."),
    INVALID_SECURITY_ANSWER_LENGTH(270005, " length must not be greater than 36 characters."),

    NO_PERMISSION_FOR_ENROLL_UNENROLL_2FA(270006,
            "You do not have permission to enroll or un-enroll to two factor authentication."),
    LOGIN_RESTRICTED_DUE_TO_2FA_MASQ_USER(270008, "You are not allowed to enable 2FA enrollment."),

    //Security Group errors
    INVALID_PERMISSION_TYPE(290001, "Permission {permissiontype} is not allowed for this entity: "),
    REPEATING_SEC_GROUP_ENTRY_TYPE(290002, "Multiple entries with same type cannot exist. "),
    NOT_AVAILABLE(290003, "This functionality currently is not available"),
    REPEATING_SEC_GROUP_EXCEPTION_ENTRY(290004, "Multiple entries with same exception record cannot exist. "),

    // Address errors
    INVALID_COUNTRY_CODE(300001, "Invalid country code '%s'"),
    INVALID_STATE_CODE(300002, "Invalid state code '%s'"),
    NON_PRIMARY_USER_ERROR(300003, "Only primary user has permission to update '%s'"),
    CANNOT_UPDATE_ACCOUNT_HOLDER_ADDRESS(300004,
            "accountHolderAddress information can be updated only for accounts with accountType as ORGANIZATION"),
    //Account TTL error
    TTL_LIST_IS_EMPTY(310001, "Invalid data was submitted in the body."),
    TTL_SBTC_MIN_MAX_VALIDATION_MSG(310002, "For SBTC type, Min and Max value must be 30 and 900 respectively."),
    TTL_TYPE_REQUIRED_VALIDATION_MSG(310003, "Resource record 'type' attribute is required."),
    TTL_TYPE_MUTIPLE_ENTRY_REC_MSG(310004, "Input should contain unique resource record types."),
    TTL_NO_WRITE_PERMISSION(310005,
            "You have permission to get the account info, but do not have permission to modify the account ttls."),
    TTL_DEF_MIN_MAX_ALL_NULL(310006, "At least one of defaultValue, min or max should be provided."),

    // Messages related to Retry operation.
    RETRY_ON_DEADLOCK(32000,
            "We are not able to process your request at this time. Please retry request again after some time."),

    // Reporter service
    UNABLE_TO_FULFILL_REPORTER_REQUEST(33000,
            "Could not complete your request at this time. Please retry request again after some time."),

    // Conectivity problems
    CONN_PROBLEM_TOKEN(340000, "Internal connectivity problem."),

    TOO_MANY_REQUESTS(340001, "Too many requests."),

    TWO_FACTOR_MISS_MOBILE_NUMBER(350000,
            "No Mobile Number was found on your profile. Please update the My Profile section with a valid"
                    + " Mobile Number before attempting to enable Two Factor Mobile Authentication."),
    TWO_FACTOR_MISS_MOBILE_NUMBER_INVALID(360000, "The Mobile Number in the My Profile section is in an invalid format."
            + " Please verify the phone number format and try again."),

    //Error in to email delivery
    EMAIL_ERROR(350000,
            "We are not able to process your request at this time. Please retry request again after some time."),

    //ZBR error in case ZBR feature flag not enabled for all accounts related to user.
    NO_USER_ACCOUNTS_WITH_ZBR_FEATURE_FLAG_ON(370000,
            "Zone snapshot or restore feature is currently not enabled for your account. Please contact UltraDNS "
                    + "customer support at +1 (844) 929-0808 or dns.ultraproducts.support"
                    + "."),

    //ZBR zone restore does not allow pool
    PROFILE_ENTRTY_NOT_ALLOWED(370001, "Zone with pools cannot be restored."),

    //zone not eligible for restore
    ZONE_NOT_ELIGIBLE_RESTORE(370002, "Zone %s is not eligible for restore."),

    //SAML contact info empty errors
    SAML_CONTACT_NAME_EMPTY(380001, "SAML point of contact name is required."),
    SAML_CONTACT_EMAIL_EMPTY(380002, "SAML point of contact email is required."),
    SAML_CONTACT_PHONE_EMPTY(380003, "SAML point of contact phone is required."),

    //saml nameid empty error
    SAML_NAME_ID_EMPTY(380004, "SAML nameID is required."),
    SAML_VANITY_URL_EMPTY(380005, "DNS URL to access SAML service provider is required."),

    // idp related xml file is missing
    SAML_IDP_META_DATA_FILE(380005, "SAML IDP meta-data file is required."),

    //saml vanity url already taken
    SAML_VANITY_URL_TAKEN(380006, "DNS Url found to access SAML service provider is already taken."),

    SAML_CONFIGURATION_DATA_NOT_FOUND(380007, "No SAML configuration data found for this account."),
    SAML_UDNS_USERNAME_MISSING(380008, "UDNS username is missing for the user."),
    SAML_EMAIL_ADDRESS_MISSING(380009, "Email address is missing for the user."),
    SAML_NAME_ID_FOR_ASSERTION_MISSING(380010, "Saml Assertion nameID is missing for the user."),

    //saml vanity url already exists
    SAML_VANITY_URL_EXISTS(380015, "DNS Url found to access SAML service provider already exists."),

    //saml vanity url already exists
    SAML_ACCOUNT_DOES_NOT_EXIST(380016, "No existing account found to copy the user setting up SSO."),

    SAML_NO_MAPPING_FOUND_FOR_EXISTING_USER(380017, "User already copied for SSO as part of other account,"
            +  " but cannot find mapping for ID's."),

    SAML_META_DATA_READ_ERROR(380018, "IDP Metadata read error. Should not happen, "
            + "but if happens, please contact UltraDNS customer support."),
    SAML_META_DATA_PARSE_ERROR(380019, "Metadata format is invalid according to SAML spec."
            + " Correct the XML file and resubmit."),
    SAML_NAME_ID_FORMAT_CONFLICT(380020, "Name ID parameter selected during form submission "
            + "is different than the one in Metadata XML file"),
    SAML_WRONG_META_DATA(380020, "Name ID parameter selected during form submission "
            + "is different than the one in Metadata XML file"),
    SAML_FORGE_ROCK_UNKNOWN_ERROR(380021, "Forgerock sent an unexpected IDP meta-data validation error."),

    ACCOUNT_ALLOWED_IP_GUID_ERROR(2610, "No guid specified for Account IP Range"),

    // Reset Password error
    RESET_PASSWORD_INVALID_URL(390001, "Sorry, the password reset URL is not recognized."
            + " Please try entering it again or request a password reset URL again."),

    // Recaptcha error
    INVALID_CAPTCHA_RESPONSE(400001, "Invalid captcha - Please try entering it again.."),

    /**
     * Custom UserId not found error.
     */
    USER_ID_NOT_FOUND(410001, "No existing user found with given email address."),
    USERNAME_ALREADY_EXISTS(410002, "Provided Username already exists in the system."),

    // Token type error
    INVALID_TOKEN_TYPE(420001, "Invalid token type"),

    // DS Record related errors
    INVALID_DS_RDATA_FORMAT(430001, "Invalid Input: Expected rdata format for DS record is"
            + " [\"<key tag> <algorithm> <digest type> <digest>\"]"),
    INVALID_DS_KEYTAG(430002, "Invalid Input: Key Tag is invalid."),
    INVALID_DS_ALGO(430003, "Invalid Input: Algorithm not supported."),
    INVALID_DS_DIGEST_TYPE(430004,
            "Invalid Input: Digest Type must be one of - 1: SHA-1, 2: SHA-256, 3: GOST3411, 4: SHA-384"),
    INVALID_DS_DATA_HEX_CODE(430005,
            "Invalid Input: Digest should be valid hexadecimal value of length '%s' as per provided Digest Type '%s'."),

    // SSHFP Record related errors
    INVALID_SSHFP_RDATA_FORMAT(440001, "Invalid Input: Expected rdata format for SSHFP record is"
            + " [\"<algorithm> <fingerprint type> <fingerprint>\"]"),
    INVALID_SSHFP_ALGO(440002, "Invalid Input: SSHFP algorithm must be one of - 1: RSA, 2: DSS, 3: ECDSA, 4: Ed25519"),
    INVALID_SSHFP_FINGERPRINT_TYPE(440003,
            "Invalid Input: SSHFP fingerprint type must be one of - 1: SHA-1, 2: SHA-256"),
    INVALID_SSHFP_DATA_HEX_CODE(440004, "Invalid Input: Fingerprint should be valid hexadecimal value of length "
            + "'%s' as per provided Fingerprint Type '%s'."),

    // Duplicate rdata error
    DUPLICATE_VALUES_RRDATA_CODE(450001, "Resource Record with these attributes already exists in the system."),

    // Null MX Record related errors
    DIRECTIONAL_POOL_WITH_NULL_MX_NOT_ALLOWED(460001, "Directional pool with null MX record is not allowed."),
    INVALID_INPUT_RRSET_NULL_MX(460002,
            "Rdata cannot have additional records if Null MX record is specified in the input."),
    NULL_MX_ALREADY_EXISTS(460003,
            "Cannot add any further MX record or directional pool as domain already contains Null MX record."),
    CANNOT_ADD_NULL_MX_WHEN_NORMAL_EXISTS(460004,
            "Can not add null MX record as a normal MX record exists for this domain."),

    // Account Service error
    ACCOUNT_SERVICE_CONN_ISSUE(490001,
            "Error while communicating with account service."),
    ACCOUNT_SERVICE_RESPONSE_MAPPING_ISSUE(490002,
            "Error while mapping the account service response to AccountInfoList."),
    NO_PERMISSION_ON_SUB_ACCOUNTS_ERROR(490003, "You do not have permissions to perform any activity on sub-accounts"),
    ONLY_SUB_ACCOUNTS_ALLOWED_ERROR(490004, "You can perform this activity on sub-accounts only"),
    SUB_ACCOUNT_CANT_BE_LOCATED_ERROR(490005, "The sub-account '%s' cannot be located"),
    SUB_ACCOUNT_SUSPENDED_ERROR(490006, "The sub-account '%s' is suspended"),
    SUB_ACCOUNT_NOT_PROPERLY_SETUP_ERROR(490007,
            "The account %s is not correctly configured in the system. Please contact UltraDNS customer "
                    + "support at +1 (844) 929-0808 or dns.ultraproducts.support."),
    NO_SUB_ACCOUNTS_EXISTS(490004, "No sub accounts exists."),
    ACCOUNTS_NOT_ON_ULTRA_FLASH_PIPELINE(490009,
            "Operation is not supported for the provided source and target account combination."),
    ZONE_EXISTS_IN_ANOTHER_ACCOUNT(1891, "Zone already exists in another UltraDNS customer account."),
    ZONE_EXISTS_IN_CURRENT_ACCOUNT(1892, "Zone already exists in the account '%s'."),
    ZONE_EXISTS_IN_ANOTHER_ACCOUNT_OF_SAME_SPONSOR(1893,
            "Zone already exists in another account under the same sponsor.");

    /**
     * Error code.
     */
    private int errorCode;
    /**
     * Error message.
     */
    private String errorMessage;

    /**
     * Parameterized constructor.
     *
     * @param errorCode    - Error code
     * @param errorMessage - Error message
     */
    UltraRestErrorConstant(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * Get error message.
     *
     * @return - Error message.
     */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * Get error code.
     *
     * @return - error code.
     */
    public int getErrorCode() {
        return this.errorCode;
    }

};
