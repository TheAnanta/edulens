import Sidebar from "@/components/Sidebar";
import EventCard from "./EventCard";
import Footer from "@/components/Footer";

const eventsData = {
  January: [
    { eventName: "Shore Fest", location: "Open Audi", date: 10, description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor" },
    { eventName: "Tech Expo", location: "Innovation Hub", date: 15, description: "Discover the latest in technology." },
    { eventName: "Guest Lecture", location: "Seminar Hall", date: 20, description: "A renowned expert on AI will speak." },
  ],
  February: [
    { eventName: "Coding Challenge", location: "Computer Lab", date: 5, description: "Compete for prizes in a coding competition." },
    { eventName: "Sports Day", location: "Sports Ground", date: 15, description: "Celebrate with games and activities." },
    { eventName: "Career Fair", location: "Convention Center", date: 25, description: "Meet potential employers and learn about career options." },
  ],
};

export default function Page(props: { params: { id: string } }) {
  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-24 px-16 w-full my-6">
        <div>
          <p className="w-full text-center text-4xl font-bold  ">Event Calender</p>
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
                  description={event.description}
                />
              ))}
            </div>
          </div>
        ))}

        <Footer />
      </div>
    </div>
  );
}