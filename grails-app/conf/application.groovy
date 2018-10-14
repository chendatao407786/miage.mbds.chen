

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'miage.mbds.chen.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'miage.mbds.chen.UserRole'
grails.plugin.springsecurity.authority.className = 'miage.mbds.chen.Role'
grails.plugin.springsecurity.securityConfigType = 'Annotation'
grails.plugin.springsecurity.requestMap.className = 'miage.mbds.chen.UserRole'
grails.plugin.springsecurity.auth.loginFormUrl = '/login/auth'
grails.plugin.springsecurity.successHandler.allwaysUseDefault = true
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/user/index'
grails.plugin.springsecurity.rest.token.storage.jwt.secret = 'qrD6h8K6S9503Q06Y6Rfk21TErImPYqa'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]
//grails.plugin.springsecurity.filterChain.chainMap = [
////Stateless chain
//	[pattern: '/**', 			filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],
////Traditional, stateful chain
//	[pattern: '/stateful/**', 	filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
//]

