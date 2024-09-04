import Sidebar from "@/components/Sidebar";
import EventCard from "./EventCard";
import Footer from "@/components/Footer";

const eventsData = {
  January: [
    {
      eventName: "Shore Fest",
      location: "Open Audi",
      date: 10,
      description:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
      url: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSW2RBgfBfXzryldvlBcNrIg8XBU4vroGHjaQ&s",
    },
    {
      eventName: "GDG DevFest 2024",
      location: "Innovation Hub",
      date: 15,
      description: "Discover the latest in technology.",
      url: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz7D5lkPQvqtAErxS08Vw8d5EzLRCeL6xuLg&s",
    },
    {
      eventName: "GDSC WOW",
      location: "Seminar Hall",
      date: 20,
      description: "A renowned expert on AI will speak.",
      url: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQ-9aVk5QVvUlmnaFYzizV-0WB4z5AnXDlBA&s",
    },
  ],
  February: [
    {
      eventName: "MDC Coding Challenge",
      location: "Computer Lab",
      date: 5,
      description: "Compete for prizes in a coding competition.",
      url: "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/meta-icon.png",
    },
    {
      eventName: "GitHub Hackathon",
      location: "Mother Teresa Auditorium",
      date: 16,
      description: "Celebrate with games and activities.",
      url: "https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg",
    },
    {
      eventName: "Career Fair",
      location: "Convention Center",
      date: 25,
      description: "Meet potential employers and learn about career options.",
      url: "https://upload.wikimedia.org/wikipedia/commons/f/fa/Apple_logo_black.svg",
    },
  ],
};

export default function Page(props: { params: { id: string } }) {
  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-24 px-16 w-full my-6">
        <div>
          <p className="w-full text-center text-4xl font-bold  ">
            Event Calender
          </p>
        </div>

        {Object.entries(eventsData).map(([month, events]) => (
          <div key={month} className="mb-10">
            <div className="text-3xl font-semibold">
              <p className="text-left">{month} - 2024</p>
            </div>
            <div className="grid grid-cols-3 mt-12 gap-8 w-full">
              {events.map((event, index) => (
                <EventCard
                  key={index}
                  eventName={event.eventName}
                  location={event.location}
                  date={event.date}
                  url={event.url}
                  description={event.description}
                />
              ))}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
