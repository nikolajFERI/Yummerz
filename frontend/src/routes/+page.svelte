<script lang="ts">
  import { goto } from '$app/navigation';
</script>

<main>
  <h1>Dobrodošli v Knjigo Receptov Yummerz</h1>
  <p>Pritisnite gumb spodaj za ogled receptov.</p>
  <button on:click={() => goto('/recipes')} class="primary">
    Pokaži Recepte
  </button>
</main>

<style>
  main {
    max-width: 600px;
    margin: 4rem auto;
    text-align: center;
  }
  button {
    padding: 0.75rem 1.5rem;
    background: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 1rem;
  }
</style>
