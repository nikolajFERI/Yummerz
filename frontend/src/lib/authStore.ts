import { writable } from 'svelte/store';

const isBrowser = typeof window !== 'undefined';
const initialToken = isBrowser ? localStorage.getItem('token') : null;

export const token = writable<string | null>(initialToken);

if (isBrowser) {
    token.subscribe((value) => {
        if (value) {
            localStorage.setItem('token', value);
        } else {
            localStorage.removeItem('token');
        }
    });
}