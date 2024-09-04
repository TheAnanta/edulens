import Sidebar from "@/components/Sidebar";
import PlacementCard from "./PlacementCard";
import Footer from "@/components/Footer";

const eventsData = [
  {
    eventName: "Amazon",
    location: "On Campus",
    placed: 4,
    avgLpa: 16,
    url: "/amazon.png",
  },
  {
    eventName: "Apple",
    location: "Off Campus",
    placed: 1,
    avgLpa: 26,
    url: "https://upload.wikimedia.org/wikipedia/commons/f/fa/Apple_logo_black.svg",
  },
  {
    eventName: "Microsoft",
    location: "Off Campus",
    placed: 3,
    avgLpa: 15,
    url: "https://upload.wikimedia.org/wikipedia/commons/4/44/Microsoft_logo.svg",
  },
  {
    eventName: "Meta",
    location: "Off Campus",
    placed: 5,
    avgLpa: 23,
    url: "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/meta-icon.png",
  },
  {
    eventName: "Google",
    location: "On Campus",
    placed: 1,
    avgLpa: 33,
    url: "https://upload.wikimedia.org/wikipedia/commons/c/c1/Google_%22G%22_logo.svg",
  },
];

export default function Page(props: { params: { id: string } }) {
  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-24 px-16 w-full my-6">
        <div>
          <p className="w-full text-center text-4xl font-bold  ">Placements</p>
        </div>

        <div className="grid grid-cols-3 mt-12 gap-8 w-full mb-20">
          {eventsData.map((event, index) => (
            <PlacementCard
              key={index}
              eventName={event.eventName}
              location={event.location}
              placed={event.placed}
              avgLpa={event.avgLpa}
              url={event.url}
            />
          ))}
        </div>
      </div>
    </div>
  );
}
