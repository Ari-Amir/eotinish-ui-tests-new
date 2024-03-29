-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlNoDataSourceInspection

INSERT INTO public.applicants(
    id,
    applicant_type,
    iinbin,
    person_resident,
    person_first_name,
    person_second_name,
    person_middle_name,
    person_birth_date,
    person_gender_id,
    person_citizenship_id,
    person_nationality_id,
    person_social_status_id,
    person_occupation_id,
    person_law_address,
    person_fact_address,
    company_name,
    company_reg_date,
    company_law_address,
    company_fact_address,
    company_head_first_name,
    company_head_second_name,
    company_head_middle_name,
    company_business_category,
    company_appeal_out_number,
    applicants_count,
    attorney_id,
    mobile_phone,
    work_home_phone,
    email,
    created_date,
    modified_date)
VALUES(
          '#ID_APPLICANTS#',
          'PERSON',
          '123123123123',
          null,
          'AUTOTEST',
          'AUTOTEST',
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          'AUTOTEST ADDRESS',
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          '#CREATED_DATE_APPLICANTS#',
          '#MODIFIED_DATE_APPLICANTS#');


INSERT INTO public.appeals_applications(
id,
type_id,
issue_category_id,
subissue_category_id,
location_id,
org_id,
data,
assistant_user_id,
files,
signature,
created_date,
modified_date,
response_get_way,
language_id,
applicant_id,
appeal_form,
appeal_character,
complaint_appeal_id,
complaint_location_id,
complaint_organization_id,
complaint_executive_user_id,
complaint_type_id,
complaint_executive_name,
complaint_appeal_sid,
person_age)
VALUES (
'#ID_AA#',
'#TYPE_ID_AA#',
'26bc0c62-0bc4-4d2f-9f81-364956fccced',
'5375e79d-912f-49b2-ae32-41a69741db72',
'00',
1111,
'AUTOTEST APPEAL DESCRIPTION',
'4689c39d-c959-4a78-9706-77b2b6228822',
'[]',
'{"version":"APPEAL_V4","signBase64":"TUlJSXRBWUpLb1pJaHZjTkFRY0NvSUlJcFRDQ0NLRUNBUUV4RHpBTkJnbGdoa2dCWlFNRUFnRUZBREFMQmdrcWhraUc5dzBCQndHZ2dnWStNSUlHT2pDQ0JDS2dBd0lCQWdJVUdHbEZhZE1URnVoSmZkbE1DMzg0bTJncmRYSXdEUVlKS29aSWh2Y05BUUVMQlFBd1VqRUxNQWtHQTFVRUJoTUNTMW94UXpCQkJnTlZCQU1NT3RLdzBKdlFvdENpMEt2U21pRFFtdENqMDVqUW05Q1EwSjNRbE5DcjBLRFFvOUNvMEtzZzBKN1FvTkNpMEpEUW05Q3IwcG9nS0ZKVFFTa3dIaGNOTWpJd09EQXlNVE16T1RBMVdoY05Nak13T0RBeU1UTXpPVEExV2pCOU1SVXdFd1lEVlFRRURBelFrTkNjMEpqUW9OQ2UwSkl4SkRBaUJnTlZCQU1NRzlDUTBKelFtTkNnMEo3UWtpRFFrTkNnMEt2UW9kQ2kwSkRRblRFWU1CWUdBMVVFQlJNUFNVbE9PREF3TXpJNU16QXdOVGd4TVFzd0NRWURWUVFHRXdKTFdqRVhNQlVHQTFVRUtnd08wSkhRbGRDYTBKN1FrdENZMEtjd2dnRWlNQTBHQ1NxR1NJYjNEUUVCQVFVQUE0SUJEd0F3Z2dFS0FvSUJBUUN0WitUeUdKbkhGU3BzeDlEbktNS1VUaHppcTF2T0VOOGxLSUJOcFNubXhScnBodmJOM2xqUi8zaUhFTkVQWEJUNTdUZFlyVExFQmhJVy9GUmtSNWJQRVBQYkFDaWdONGlySEtkcjZ3Q0xLd3hYdEQ5dmpuQ3JSY1NlSlAyVmxFQndGNitTVzNEQ3Bsc1FVMm9TbnJURkNTWThGVkg1R2U3eFhaaDlqK0NQUnU5eXk2bXFIOURkM2kwL1JkRXIwbGMxcFgxcnlDNGVUVDVzdnhsd0IwcldIUXVtNzZOVnA3NUd2WE0yRG1JMStqbjZwcWphY2dPREVPM3REdGRIaTRsUW52WXlURy9nQTYxOXc4emdOUEx6N2hheldNemY3UWFaOXVHZnZrR3FDK3JiUjhUU0NjOUkzY1dBbXlHaW5VclVZN2FaVDVMRlNvSU9Sb3BmUnVOYkFnTUJBQUdqZ2dIYk1JSUIxekFPQmdOVkhROEJBZjhFQkFNQ0JzQXdIUVlEVlIwbEJCWXdGQVlJS3dZQkJRVUhBd1FHQ0NxRERnTURCQUVCTUE4R0ExVWRJd1FJTUFhQUJGdHFkQkV3SFFZRFZSME9CQllFRkRvSUNrdkhCN2tNS0FwdVd0em1vMHptbWw5ek1GNEdBMVVkSUFSWE1GVXdVd1lIS29NT0F3TUNBekJJTUNFR0NDc0dBUVVGQndJQkZoVm9kSFJ3T2k4dmNHdHBMbWR2ZGk1cmVpOWpjSE13SXdZSUt3WUJCUVVIQWdJd0Z3d1ZhSFIwY0RvdkwzQnJhUzVuYjNZdWEzb3ZZM0J6TUZZR0ExVWRId1JQTUUwd1M2QkpvRWVHSVdoMGRIQTZMeTlqY213dWNHdHBMbWR2ZGk1cmVpOXVZMkZmY25OaExtTnliSVlpYUhSMGNEb3ZMMk55YkRFdWNHdHBMbWR2ZGk1cmVpOXVZMkZmY25OaExtTnliREJhQmdOVkhTNEVVekJSTUUrZ1RhQkxoaU5vZEhSd09pOHZZM0pzTG5CcmFTNW5iM1l1YTNvdmJtTmhYMlJmY25OaExtTnliSVlrYUhSMGNEb3ZMMk55YkRFdWNHdHBMbWR2ZGk1cmVpOXVZMkZmWkY5eWMyRXVZM0pzTUdJR0NDc0dBUVVGQndFQkJGWXdWREF1QmdnckJnRUZCUWN3QW9ZaWFIUjBjRG92TDNCcmFTNW5iM1l1YTNvdlkyVnlkQzl1WTJGZmNuTmhMbU5sY2pBaUJnZ3JCZ0VGQlFjd0FZWVdhSFIwY0RvdkwyOWpjM0F1Y0d0cExtZHZkaTVyZWpBTkJna3Foa2lHOXcwQkFRc0ZBQU9DQWdFQWtXUHBnL2dZbFExRHdLMnhrc1dBT09NZ0RWVFRndEFyRDZFSnFNZE1PdkRiYUo1dGgyVVk2c1RRL01EeHkvSDVScVYxZ3pJNitqeEFLQk45QW9zUVBVMFJRd0VlcEZ6RlIwdVZLeVUzeFVKUFpBSHU0WHBtODlLSnpZQXltQ1Q5YmFvRGNkUEhmUU5ORXdTY09VTUxnbFZVV25SM1dnQUpZWmJEaHdRSmlyb2tRMHR5SlFPMFVCQ2J6MVZYRmEwaWdHQmFFKzZqUm93UDIwT0NaaVZna1BOdGlxQU1rZmVTUFgrbDMyTTJpZ215aEpDN1FDT2pMRFVVM0htRFdkRTlhZTdNd3I3TmlKamxQajArY1pDOEZDcEcxemxJMXlPL2VMOVFqTWZ1TGtTUXk3TnFZcVMrSVhZNWFFZ1EvY0NjUEdIazhNNFpKTzN3T3JzUzYxRjZPTmlmM0ZwNWJ6VGpzb1ZGWEE0eURrOS9HREtKVmJMdE5JbDdCUERVbWdjQ0oybkFWdDB3MndMVWFMSnNhcTExMjN3a1dLcWMxck5tYThvVjd2dS8yVU9DdS9aR0NXcjRtR0tQMEFzbWo3VU5CclI5OVV4TURSajcwY2c4VVhDbmYzUmRxZHJsUkZnZWJrTTl4UmFHR09BbTNNYU14aEZZT1lmSVpBN3ZYbzVnUzVRRWNCVVk2ekFWVzJLZkFpQW1qUFY1dktWcmdHdklBVHh6WXZENktBd2laMTJrLzVDUG1GVitZN1l0MU5zMVVoMC9vMGMydy9zTkp1WjI3a0VvdHdkaFMwWldQYnNoRmRlQlQ3UlNzZUdDN2VFOUE5YVdBampteVFJcUZVR3grdy8yNGR3bkdHaWZ4SFZuRjBNc0JDRzhBYUVvUlJnL0ZwYXQ1ZlpIN3dveGdnSTZNSUlDTmdJQkFUQnFNRkl4Q3pBSkJnTlZCQVlUQWt0YU1VTXdRUVlEVlFRREREclNzTkNiMEtMUW90Q3IwcG9nMEpyUW85T1kwSnZRa05DZDBKVFFxOUNnMEtQUXFOQ3JJTkNlMEtEUW90Q1EwSnZRcTlLYUlDaFNVMEVwQWhRWWFVVnAweE1XNkVsOTJVd0xmemliYUN0MWNqQU5CZ2xnaGtnQlpRTUVBZ0VGQUtDQm9qQVlCZ2txaGtpRzl3MEJDUU14Q3dZSktvWklodmNOQVFjQk1Cd0dDU3FHU0liM0RRRUpCVEVQRncweU1qQTVNRFF4TXpRNE1UQmFNQzhHQ1NxR1NJYjNEUUVKQkRFaUJDQ0hKN1dwYmhMQTlIMWZmV1NHdFdpdGdPeWJUNTliU0kyUVpjNDVpbUdCaGpBM0Jnc3Foa2lHOXcwQkNSQUNMekVvTUNZd0pEQWlCQ0RzUy9NZHI4Uis5RUV1TnVPMVE3RFhsV3pHUnQ1bmRPWHJhQVpjVGQwNmp6QU5CZ2txaGtpRzl3MEJBUXNGQUFTQ0FRQUZ1cytVOHZEZ2hlTEtGTWthbWc3NUU0cUlmZktDanljZ2tDUUhzazZ0ZXVSZW1vVC84UU5JbUNzZ0JWSVQwbjFTYzVQMGVPUnVIVm56aWV1SkxFN1Frc29Tdytla0E2VHZhczdOek51SFFVd3JnZm5BSHBnQk9veGIrdStjZTQ4RThmTmNCTlFOR0lMd0Q2RFlmY1prT203aUdxeFRLTnJXci84Z2h5Ync3S3dGZk1BTEdVUnJ5djg0OExMNVFoeFlqNmVIRitVcFVYbkZGTEtzUGVwa1hpTnNDaVRsWFU0V3lRUkxDMWN1Qkg0UHNTM0lJc2pnSXVKMzdUOXpaR0dtb3Ivcks2bXFEc3pMR21ja2NCcUJWQ2pPbW1hUkZuby9vK1lMdDlwdVNLUzN2ejh1aThOWUYzeVNCYUdnOVBZWnN1MU01YkN2QVdjOHkrOVVvazh3"}',
'#CREATED_DATE_AA#',
'#MODIFIED_DATE_AA#',
'PCS',
'14aafdaf-fb58-41d9-987a-8c33eba3d1a4',
'#APPLICANT_ID_AA#',
'PAPER_ON_PURPOSE',
'INDIVIDUAL',
null,
#COMPLAINT_LOCATION_ID_AA#,
#COMPLAINT_ORGANIZATION_ID_AA#,
null,
#COMPLAINT_TYPE_ID_AA#,
null,
null,
null);


INSERT INTO public.appeals_history(
id,
type,
state,
working_state,
message,
scope,
actor_user_id,
system_message_ru,
files,
appeal_id,
sign,
created_date,
modified_date,
date,
actor_org_id,
target_org_id,
system_message_kk,
eds_info)
VALUES (
'#ID_AH#',
'CHANGE_STATUS',
'CREATED',
'NEW',
null,
'ALL',
'4689c39d-c959-4a78-9706-77b2b6228822',
'Автор: Регистратор-1 (Org.1) ( - AUTOTEST ORG 1) ',
'[]',
'#APPEAL_ID_AH#',
'{"version":"APPEAL_V4","signBase64":"TUlJSXRBWUpLb1pJaHZjTkFRY0NvSUlJcFRDQ0NLRUNBUUV4RHpBTkJnbGdoa2dCWlFNRUFnRUZBREFMQmdrcWhraUc5dzBCQndHZ2dnWStNSUlHT2pDQ0JDS2dBd0lCQWdJVUdHbEZhZE1URnVoSmZkbE1DMzg0bTJncmRYSXdEUVlKS29aSWh2Y05BUUVMQlFBd1VqRUxNQWtHQTFVRUJoTUNTMW94UXpCQkJnTlZCQU1NT3RLdzBKdlFvdENpMEt2U21pRFFtdENqMDVqUW05Q1EwSjNRbE5DcjBLRFFvOUNvMEtzZzBKN1FvTkNpMEpEUW05Q3IwcG9nS0ZKVFFTa3dIaGNOTWpJd09EQXlNVE16T1RBMVdoY05Nak13T0RBeU1UTXpPVEExV2pCOU1SVXdFd1lEVlFRRURBelFrTkNjMEpqUW9OQ2UwSkl4SkRBaUJnTlZCQU1NRzlDUTBKelFtTkNnMEo3UWtpRFFrTkNnMEt2UW9kQ2kwSkRRblRFWU1CWUdBMVVFQlJNUFNVbE9PREF3TXpJNU16QXdOVGd4TVFzd0NRWURWUVFHRXdKTFdqRVhNQlVHQTFVRUtnd08wSkhRbGRDYTBKN1FrdENZMEtjd2dnRWlNQTBHQ1NxR1NJYjNEUUVCQVFVQUE0SUJEd0F3Z2dFS0FvSUJBUUN0WitUeUdKbkhGU3BzeDlEbktNS1VUaHppcTF2T0VOOGxLSUJOcFNubXhScnBodmJOM2xqUi8zaUhFTkVQWEJUNTdUZFlyVExFQmhJVy9GUmtSNWJQRVBQYkFDaWdONGlySEtkcjZ3Q0xLd3hYdEQ5dmpuQ3JSY1NlSlAyVmxFQndGNitTVzNEQ3Bsc1FVMm9TbnJURkNTWThGVkg1R2U3eFhaaDlqK0NQUnU5eXk2bXFIOURkM2kwL1JkRXIwbGMxcFgxcnlDNGVUVDVzdnhsd0IwcldIUXVtNzZOVnA3NUd2WE0yRG1JMStqbjZwcWphY2dPREVPM3REdGRIaTRsUW52WXlURy9nQTYxOXc4emdOUEx6N2hheldNemY3UWFaOXVHZnZrR3FDK3JiUjhUU0NjOUkzY1dBbXlHaW5VclVZN2FaVDVMRlNvSU9Sb3BmUnVOYkFnTUJBQUdqZ2dIYk1JSUIxekFPQmdOVkhROEJBZjhFQkFNQ0JzQXdIUVlEVlIwbEJCWXdGQVlJS3dZQkJRVUhBd1FHQ0NxRERnTURCQUVCTUE4R0ExVWRJd1FJTUFhQUJGdHFkQkV3SFFZRFZSME9CQllFRkRvSUNrdkhCN2tNS0FwdVd0em1vMHptbWw5ek1GNEdBMVVkSUFSWE1GVXdVd1lIS29NT0F3TUNBekJJTUNFR0NDc0dBUVVGQndJQkZoVm9kSFJ3T2k4dmNHdHBMbWR2ZGk1cmVpOWpjSE13SXdZSUt3WUJCUVVIQWdJd0Z3d1ZhSFIwY0RvdkwzQnJhUzVuYjNZdWEzb3ZZM0J6TUZZR0ExVWRId1JQTUUwd1M2QkpvRWVHSVdoMGRIQTZMeTlqY213dWNHdHBMbWR2ZGk1cmVpOXVZMkZmY25OaExtTnliSVlpYUhSMGNEb3ZMMk55YkRFdWNHdHBMbWR2ZGk1cmVpOXVZMkZmY25OaExtTnliREJhQmdOVkhTNEVVekJSTUUrZ1RhQkxoaU5vZEhSd09pOHZZM0pzTG5CcmFTNW5iM1l1YTNvdmJtTmhYMlJmY25OaExtTnliSVlrYUhSMGNEb3ZMMk55YkRFdWNHdHBMbWR2ZGk1cmVpOXVZMkZmWkY5eWMyRXVZM0pzTUdJR0NDc0dBUVVGQndFQkJGWXdWREF1QmdnckJnRUZCUWN3QW9ZaWFIUjBjRG92TDNCcmFTNW5iM1l1YTNvdlkyVnlkQzl1WTJGZmNuTmhMbU5sY2pBaUJnZ3JCZ0VGQlFjd0FZWVdhSFIwY0RvdkwyOWpjM0F1Y0d0cExtZHZkaTVyZWpBTkJna3Foa2lHOXcwQkFRc0ZBQU9DQWdFQWtXUHBnL2dZbFExRHdLMnhrc1dBT09NZ0RWVFRndEFyRDZFSnFNZE1PdkRiYUo1dGgyVVk2c1RRL01EeHkvSDVScVYxZ3pJNitqeEFLQk45QW9zUVBVMFJRd0VlcEZ6RlIwdVZLeVUzeFVKUFpBSHU0WHBtODlLSnpZQXltQ1Q5YmFvRGNkUEhmUU5ORXdTY09VTUxnbFZVV25SM1dnQUpZWmJEaHdRSmlyb2tRMHR5SlFPMFVCQ2J6MVZYRmEwaWdHQmFFKzZqUm93UDIwT0NaaVZna1BOdGlxQU1rZmVTUFgrbDMyTTJpZ215aEpDN1FDT2pMRFVVM0htRFdkRTlhZTdNd3I3TmlKamxQajArY1pDOEZDcEcxemxJMXlPL2VMOVFqTWZ1TGtTUXk3TnFZcVMrSVhZNWFFZ1EvY0NjUEdIazhNNFpKTzN3T3JzUzYxRjZPTmlmM0ZwNWJ6VGpzb1ZGWEE0eURrOS9HREtKVmJMdE5JbDdCUERVbWdjQ0oybkFWdDB3MndMVWFMSnNhcTExMjN3a1dLcWMxck5tYThvVjd2dS8yVU9DdS9aR0NXcjRtR0tQMEFzbWo3VU5CclI5OVV4TURSajcwY2c4VVhDbmYzUmRxZHJsUkZnZWJrTTl4UmFHR09BbTNNYU14aEZZT1lmSVpBN3ZYbzVnUzVRRWNCVVk2ekFWVzJLZkFpQW1qUFY1dktWcmdHdklBVHh6WXZENktBd2laMTJrLzVDUG1GVitZN1l0MU5zMVVoMC9vMGMydy9zTkp1WjI3a0VvdHdkaFMwWldQYnNoRmRlQlQ3UlNzZUdDN2VFOUE5YVdBampteVFJcUZVR3grdy8yNGR3bkdHaWZ4SFZuRjBNc0JDRzhBYUVvUlJnL0ZwYXQ1ZlpIN3dveGdnSTZNSUlDTmdJQkFUQnFNRkl4Q3pBSkJnTlZCQVlUQWt0YU1VTXdRUVlEVlFRREREclNzTkNiMEtMUW90Q3IwcG9nMEpyUW85T1kwSnZRa05DZDBKVFFxOUNnMEtQUXFOQ3JJTkNlMEtEUW90Q1EwSnZRcTlLYUlDaFNVMEVwQWhRWWFVVnAweE1XNkVsOTJVd0xmemliYUN0MWNqQU5CZ2xnaGtnQlpRTUVBZ0VGQUtDQm9qQVlCZ2txaGtpRzl3MEJDUU14Q3dZSktvWklodmNOQVFjQk1Cd0dDU3FHU0liM0RRRUpCVEVQRncweU1qQTVNRFF4TXpBMU5UTmFNQzhHQ1NxR1NJYjNEUUVKQkRFaUJDQ0hKN1dwYmhMQTlIMWZmV1NHdFdpdGdPeWJUNTliU0kyUVpjNDVpbUdCaGpBM0Jnc3Foa2lHOXcwQkNSQUNMekVvTUNZd0pEQWlCQ0RzUy9NZHI4Uis5RUV1TnVPMVE3RFhsV3pHUnQ1bmRPWHJhQVpjVGQwNmp6QU5CZ2txaGtpRzl3MEJBUXNGQUFTQ0FRQngrSUlWaHJJZFdJSVZvdzViM3VyajhRWlp2NFNkNitNYVV4NmxYYmc0RDVwS2wrZElndExFZ3BGS1ZVYmdFVHptVVdlc3U0T3piZ0dPdXBmQmxIUnhHWDJIN3pVYVJPVG1tTTNXV0Jad2RIMWhlUDRrOTBySldOelRDNlgzS1JBWW1NOGVDbnJlaUsyYlFJNXpXU2JPTFNZQWhXTVVXSjc3a3ZBYmJqallsUlZ4Sy9IanFsNW9wcnB2dnN5UmMrUU8wdHVpcDFEMDJNd3ZpbXExWU5hZFRmTCtraitSRmozS0Q2SURFV0phTENwMGRLWTNZTmhMbGVTeTZIRUREakNhd3BTTXJwVHpsMVY4NzVHcWVrZU9tSE1HN3hYOFhmL1N5K2JZVHR0UGhFZ2FPRTcvU3MvK0wrTzcyaGlEQXdmdk9SZ0xZQ3VSblJFRG5WeFJKOU1r"}',
'#CREATED_DATE_AH#',
'#MODIFIED_DATE_AH#',
'#DATE_AH#',
1111,
1111,
'Автор: Регистратор-1 (Org.1) ( - AUTOTEST ORG 1) ',
'{"subject":"АМИРОВ АРЫСТАН","expiration":"02-08-2022 19:39 - 02-08-2023 19:39","sn":"18694569d31316e8497dd94c0b7f389b682b7572","issuer":"ҰЛТТЫҚ КУӘЛАНДЫРУШЫ ОРТАЛЫҚ (RSA)"}');


INSERT INTO public.appeals(
id,
reg_number,
current_state,
current_working_state,
start_date,
deadline,
finish_date,
org_id,
signer,
created_date,
modified_date,
appeal_source_id,
hidden,
checked_by_controller,
executive_org_id,
prolong_count,
complaint_exist,
executor_id,
correlation_id,
has_been_hearing,
sid,
is_duplicate_of,
is_duplicate_of_sid,
deleted,
parent_id,
last_child_reg_number,
case_number,
prolong_days,
has_lawsuit,
lawsuit_id,
lawsuit_reg_number,
lawsuit_create_date,
lawsuit_judicial_authority_info,
full_forward)
VALUES(
'#ID_A#',
'#REG_NUMBER_A#',
'CREATED',
'NEW',
'#START_DATE_A#',
'#DEADLINE_A#',
null,
1111,
null,
'#CREATED_DATE_A#',
'#MODIFIED_DATE_A#',
'PA',
false,
false,
1111,
0,
false,
null,
null,
false,
'#SID_A#',
null,
null,
false,
null,
null,
null,
0,
false,
null,
null,
null,
null,
null);
