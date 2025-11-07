
// this file is generated — do not edit it


/// <reference types="@sveltejs/kit" />

/**
 * Environment variables [loaded by Vite](https://vitejs.dev/guide/env-and-mode.html#env-files) from `.env` files and `process.env`. Like [`$env/dynamic/private`](https://svelte.dev/docs/kit/$env-dynamic-private), this module cannot be imported into client-side code. This module only includes variables that _do not_ begin with [`config.kit.env.publicPrefix`](https://svelte.dev/docs/kit/configuration#env) _and do_ start with [`config.kit.env.privatePrefix`](https://svelte.dev/docs/kit/configuration#env) (if configured).
 * 
 * _Unlike_ [`$env/dynamic/private`](https://svelte.dev/docs/kit/$env-dynamic-private), the values exported from this module are statically injected into your bundle at build time, enabling optimisations like dead code elimination.
 * 
 * ```ts
 * import { API_KEY } from '$env/static/private';
 * ```
 * 
 * Note that all environment variables referenced in your code should be declared (for example in an `.env` file), even if they don't have a value until the app is deployed:
 * 
 * ```
 * MY_FEATURE_FLAG=""
 * ```
 * 
 * You can override `.env` values from the command line like so:
 * 
 * ```sh
 * MY_FEATURE_FLAG="enabled" npm run dev
 * ```
 */
declare module '$env/static/private' {
	export const BUN_INSTALL: string;
	export const COLORTERM: string;
	export const DBUS_SESSION_BUS_ADDRESS: string;
	export const DEBUGINFOD_URLS: string;
	export const DISPLAY: string;
	export const EDITOR: string;
	export const GHOSTTY_BIN_DIR: string;
	export const GHOSTTY_RESOURCES_DIR: string;
	export const GHOSTTY_SHELL_FEATURES: string;
	export const HOME: string;
	export const LANG: string;
	export const LOGNAME: string;
	export const MAIL: string;
	export const MEMORY_PRESSURE_WATCH: string;
	export const MEMORY_PRESSURE_WRITE: string;
	export const MOTD_SHOWN: string;
	export const NODE: string;
	export const PATH: string;
	export const PWD: string;
	export const SHELL: string;
	export const SHLVL: string;
	export const SYSTEMD_EXEC_PID: string;
	export const TERM: string;
	export const TERMINFO: string;
	export const TERM_PROGRAM: string;
	export const TERM_PROGRAM_VERSION: string;
	export const USER: string;
	export const VOLTA_HOME: string;
	export const WAYLAND_DISPLAY: string;
	export const XCURSOR_SIZE: string;
	export const XDG_DATA_DIRS: string;
	export const XDG_RUNTIME_DIR: string;
	export const XDG_SEAT: string;
	export const XDG_SESSION_CLASS: string;
	export const XDG_SESSION_DESKTOP: string;
	export const XDG_SESSION_ID: string;
	export const XDG_SESSION_TYPE: string;
	export const XDG_VTNR: string;
	export const ZVM_INSTALL: string;
	export const _: string;
	export const _VOLTA_TOOL_RECURSION: string;
	export const npm_command: string;
	export const npm_config_local_prefix: string;
	export const npm_config_user_agent: string;
	export const npm_execpath: string;
	export const npm_lifecycle_event: string;
	export const npm_lifecycle_script: string;
	export const npm_node_execpath: string;
	export const npm_package_json: string;
	export const npm_package_name: string;
	export const npm_package_version: string;
	export const NODE_ENV: string;
}

/**
 * Similar to [`$env/static/private`](https://svelte.dev/docs/kit/$env-static-private), except that it only includes environment variables that begin with [`config.kit.env.publicPrefix`](https://svelte.dev/docs/kit/configuration#env) (which defaults to `PUBLIC_`), and can therefore safely be exposed to client-side code.
 * 
 * Values are replaced statically at build time.
 * 
 * ```ts
 * import { PUBLIC_BASE_URL } from '$env/static/public';
 * ```
 */
declare module '$env/static/public' {
	
}

/**
 * This module provides access to runtime environment variables, as defined by the platform you're running on. For example if you're using [`adapter-node`](https://github.com/sveltejs/kit/tree/main/packages/adapter-node) (or running [`vite preview`](https://svelte.dev/docs/kit/cli)), this is equivalent to `process.env`. This module only includes variables that _do not_ begin with [`config.kit.env.publicPrefix`](https://svelte.dev/docs/kit/configuration#env) _and do_ start with [`config.kit.env.privatePrefix`](https://svelte.dev/docs/kit/configuration#env) (if configured).
 * 
 * This module cannot be imported into client-side code.
 * 
 * ```ts
 * import { env } from '$env/dynamic/private';
 * console.log(env.DEPLOYMENT_SPECIFIC_VARIABLE);
 * ```
 * 
 * > [!NOTE] In `dev`, `$env/dynamic` always includes environment variables from `.env`. In `prod`, this behavior will depend on your adapter.
 */
declare module '$env/dynamic/private' {
	export const env: {
		BUN_INSTALL: string;
		COLORTERM: string;
		DBUS_SESSION_BUS_ADDRESS: string;
		DEBUGINFOD_URLS: string;
		DISPLAY: string;
		EDITOR: string;
		GHOSTTY_BIN_DIR: string;
		GHOSTTY_RESOURCES_DIR: string;
		GHOSTTY_SHELL_FEATURES: string;
		HOME: string;
		LANG: string;
		LOGNAME: string;
		MAIL: string;
		MEMORY_PRESSURE_WATCH: string;
		MEMORY_PRESSURE_WRITE: string;
		MOTD_SHOWN: string;
		NODE: string;
		PATH: string;
		PWD: string;
		SHELL: string;
		SHLVL: string;
		SYSTEMD_EXEC_PID: string;
		TERM: string;
		TERMINFO: string;
		TERM_PROGRAM: string;
		TERM_PROGRAM_VERSION: string;
		USER: string;
		VOLTA_HOME: string;
		WAYLAND_DISPLAY: string;
		XCURSOR_SIZE: string;
		XDG_DATA_DIRS: string;
		XDG_RUNTIME_DIR: string;
		XDG_SEAT: string;
		XDG_SESSION_CLASS: string;
		XDG_SESSION_DESKTOP: string;
		XDG_SESSION_ID: string;
		XDG_SESSION_TYPE: string;
		XDG_VTNR: string;
		ZVM_INSTALL: string;
		_: string;
		_VOLTA_TOOL_RECURSION: string;
		npm_command: string;
		npm_config_local_prefix: string;
		npm_config_user_agent: string;
		npm_execpath: string;
		npm_lifecycle_event: string;
		npm_lifecycle_script: string;
		npm_node_execpath: string;
		npm_package_json: string;
		npm_package_name: string;
		npm_package_version: string;
		NODE_ENV: string;
		[key: `PUBLIC_${string}`]: undefined;
		[key: `${string}`]: string | undefined;
	}
}

/**
 * Similar to [`$env/dynamic/private`](https://svelte.dev/docs/kit/$env-dynamic-private), but only includes variables that begin with [`config.kit.env.publicPrefix`](https://svelte.dev/docs/kit/configuration#env) (which defaults to `PUBLIC_`), and can therefore safely be exposed to client-side code.
 * 
 * Note that public dynamic environment variables must all be sent from the server to the client, causing larger network requests — when possible, use `$env/static/public` instead.
 * 
 * ```ts
 * import { env } from '$env/dynamic/public';
 * console.log(env.PUBLIC_DEPLOYMENT_SPECIFIC_VARIABLE);
 * ```
 */
declare module '$env/dynamic/public' {
	export const env: {
		[key: `PUBLIC_${string}`]: string | undefined;
	}
}
