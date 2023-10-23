<template>
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input type="checkbox" id="selectAll" v-model="selectAll" @change="toggleSelectAll"/>
          </td>
          <td>
            <input type="text" id="firstNameFilter" v-model="filter.firstName" />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          </td>
          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Inactive">Inactive</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr
          v-for="user in filteredList"
          v-bind:key="user.id"
          v-bind:class="{ deactivated: user.status === 'Inactive' }"
        >
          <td>
            <input type="checkbox" v-bind:id="user.id" v-bind:value="user.id" v-model="selectedUserIds" />
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>
            <button class="btnActivateDeactivate" @click="toggleUserStatus(user.id)">
              <!-- {{ user.status === 'Active' ? 'Deactivate' : 'Activate' }} -->
              <span v-if="user.status === 'Active'">Deactivate</span>
              <span v-else>Activate</span>
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="all-actions">
      <button @click="activateSelectedUsers" :disabled="selectedUserIds.length === 0">Activate Users</button>
      <button @click="deactivateSelectedUsers" :disabled="selectedUserIds.length === 0">Deactivate Users</button>
      <button @click="deleteSelectedUsers" :disabled="selectedUserIds.length === 0">Delete Users</button>
    </div>

    <!--Add an event listener to button-->
    <!--The inequality is meant to be able to toggle the showNewUserForm boolean-->
    <button @click="showNewUserForm = !showNewUserForm">Add New User</button>

    <!--Form shows if showNewUserForm is true-->
    <form id="frmAddNewUser" v-if="showNewUserForm" @submit.prevent="addNewUser">
      <div class="field">
        <label for="firstName">First Name:</label>
        <input v-model="newUser.firstName" type="text" id="firstName" name="firstName" />
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input v-model="newUser.lastName" type="text" id="lastName" name="lastName" />
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input v-model="newUser.username" type="text" id="username" name="username" />
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input v-model="newUser.emailAddress" type="text" id="emailAddress" name="emailAddress" />
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return { 
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: ""
      },
      nextUserId: 7,
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      },
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive"
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive"
        }
      ], 
      showNewUserForm: false, // This is the default display state of the form
      selectedUserIds: [], // Initialize an empty array to track selected IDs
      selectAll: false, // Default selectAll property
    };
  },
  methods: {
    getNextUserId() {
      return this.nextUserId++;
    },
    addNewUser() {
      this.users.push({
        id: this.getNextUserId,
        firstName: this.newUser.firstName,
        lastName: this.newUser.lastName,
        username: this.newUser.username,
        emailAddress: this.newUser.emailAddress,
        status: this.newUser.status
      });
      // After the new user has been pushed to the array, we clear the values of form
      this.newUser = {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      };
      // Hide the form after submission
      this.showNewUserForm = false;
    },
    toggleUserStatus(userId) {
      // Find user id in the users array
      this.users = this.users.map((user) => {
    if (user.id === userId) {
      // Check the user's current status and toggle it
        if (user.status === 'Active') {
          return { ...user, status: 'Inactive' };
        } else {
          return { ...user, status: 'Active' };
        }
      }
      return user;
      });
    },
    toggleSelectAll() {
      // selectAll is false by default so we need to set a conditional for when it is true
      if (!this.selectAll) {
      // If "select all" is checked, select all users
      this.selectedUserIds = this.users.map((user) => user.id);
      // Use toggleUserStatus to change the status of all users to 'Active'
      this.users.forEach((user) => {
        this.toggleSelection(user.id);
      });
    } else {
      // If "select all" is unchecked, clear selected users
      this.selectedUserIds = [];
      // Use toggleUserStatus to change the status of all users to 'Inactive'
      this.users.forEach((user) => {
        this.toggleSelection(user.id);
      });
    }
    },
    toggleSelection(userId) {
      if (this.selectedUserIds.includes(userId)) {
        // User is already selected, so remove them from the array
        const index = this.selectedUserIds.indexOf(userId);
        if (index !== -1) {
          this.selectedUserIds.splice(index, 1);
        }
      } else {
        // User is not selected, so add them to the array
        this.selectedUserIds.push(userId);
      }
    },
    activateSelectedUsers() {
      // Iterate through selectedUserIds and activate users with these IDs
      this.selectedUserIds.forEach((userId) => {
        // Set a conditional to only activate users if their status is 'Inactive'
        const user = this.getUserById(userId);
        if (user && user.status === 'Inactive') {
          this.toggleUserStatus(userId);
        }
      });
      // Clear selectedUserIds after the action is performed
      this.selectedUserIds = [];
    },
    deactivateSelectedUsers() {
      // Iterate through selectedUserIds and deactivate users with these IDs
      this.selectedUserIds.forEach((userId) => {
        // Set a conditional to only activate users if their status is 'Active'
        const user = this.getUserById(userId);
        if (user && user.status === 'Active') {
          this.toggleUserStatus(userId);
        }
      });
      // Clear selectedUserIds after the action is performed
      this.selectedUserIds = [];
    },
    deleteSelectedUsers() {
      // Filter out users with IDs in selectedUserIds to delete them
      this.users = this.users.filter((user) => !this.selectedUserIds.includes(user.id));
      // Clear selectedUserIds after the action is performed
      this.selectedUserIds = [];
    },
    getUserById(userId) {
      return this.users.find((user) => user.id === userId);
    },
  },
  computed: {
    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.status === this.filter.status
        );
      }
      return filteredUsers;
    }
  }
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.deactivated {
  color: red;
}
input,
select {
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>
