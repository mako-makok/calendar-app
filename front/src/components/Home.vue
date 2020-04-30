<template>
  <div class="home">
    <div id="nav1">
      <NavigationBar></NavigationBar>
    </div>
    <div>
      <CalendarBoard></CalendarBoard>
    </div>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import NavigationBar from '@/components/NavigationBar/NavigationBar.vue';
import CalendarBoard from '@/components/Calendar/CalendarBoard.vue';

@Component({
  components: {
    NavigationBar,
    CalendarBoard
  }
})
export default class Home extends Vue {}
</script>
